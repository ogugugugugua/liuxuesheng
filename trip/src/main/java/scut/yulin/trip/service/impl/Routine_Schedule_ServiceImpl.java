package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.routine_schedule.Insert_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Modify_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Query_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Result_Routine_Schedule_DTO;
import scut.yulin.trip.mbg.mapper.RoutineScheduleRelationDao;
import scut.yulin.trip.model.RoutineScheduleRelation;
import scut.yulin.trip.model.RoutineScheduleRelationExample;
import scut.yulin.trip.model.Schedule;
import scut.yulin.trip.service.Routine_Schedule_Service;
import scut.yulin.trip.service.ScheduleService;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class Routine_Schedule_ServiceImpl implements Routine_Schedule_Service {

  @Autowired
  RoutineScheduleRelationDao dao;

  @Qualifier("destinationServiceImpl")
  @Autowired
  ScheduleService destinationService;

  @Qualifier("hotelServiceImpl")
  @Autowired
  ScheduleService hotelService;

  @Qualifier("restaurantServiceImpl")
  @Autowired
  ScheduleService restaurantService;

  @Qualifier("vehicleServiceImpl")
  @Autowired
  ScheduleService vehicleService;

  /**
   * @return List<RoutineScheduleRelation>
   */
  @Override
  public List<Result_Routine_Schedule_DTO> getScheduleListByRoutineUUID(
      Query_Routine_Schedule_DTO query_routine_schedule_dto, Boolean getFullInformation) {
    String routineUuid = query_routine_schedule_dto.getRoutineUuid();
    if (routineUuid == null) {
      return null;
    }
    RoutineScheduleRelationExample example = new RoutineScheduleRelationExample();
    example.setLimit(query_routine_schedule_dto.getPageSize());
    example.setOffset(query_routine_schedule_dto.getOffset());
    example.setOrderByClause(CommonConstant.SCHEDULE_SERIAL);
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED)
        .andRoutineUuidEqualTo(routineUuid);
    List<RoutineScheduleRelation> relationList = dao.selectByExample(example);

    Integer relationListSize = relationList.size();
    if (relationListSize == 0) {
      return null;
    }

    List<Result_Routine_Schedule_DTO> resultList = new LinkedList<>();
    for (RoutineScheduleRelation item : relationList) {
      Result_Routine_Schedule_DTO result = new Result_Routine_Schedule_DTO();

      String typeUuid = item.getScheduleTypeUuid();
      Schedule schedule = null;
      switch (typeUuid) {
        case CommonConstant.SCHEDULE_TYPE_DESTINATION:
          schedule = destinationService
              .getScheduleByUUID(item.getScheduleUuid(), getFullInformation);
          break;
        case CommonConstant.SCHEDULE_TYPE_HOTEL:
          schedule = hotelService.getScheduleByUUID(item.getScheduleUuid(), getFullInformation);
          break;
        case CommonConstant.SCHEDULE_TYPE_RESTAURANT:
          schedule = restaurantService
              .getScheduleByUUID(item.getScheduleUuid(), getFullInformation);
          break;
        case CommonConstant.SCHEDULE_TYPE_VEHICLE:
          schedule = vehicleService.getScheduleByUUID(item.getScheduleUuid(), getFullInformation);
      }

      result.setSchedule(schedule);
      result.setRelationUuid(item.getUuid());
      result.setRoutineUuid(item.getRoutineUuid());
      result.setScheduleSerial(item.getScheduleSerial());
      result.setScheduleListSize(relationListSize);

      resultList.add(result);
    }
    return resultList;
  }

  /**
   * FIXME 在routine类实现之后需要添加校验，检查routineUuid是否有效
   *
   * @param N 假设为3，即需要把新的数据插入到4的位置，然后原本4及之后的数据统一往后移动 当插入第一个数据时 N=0，就会把数据往1的位置插
   */
  @Transactional
  @Override
  public int addScheduleAfterSerialN(Insert_Routine_Schedule_DTO dto, Integer N) {
    String routineUuid = dto.getRoutineUuid();
    if (routineUuid == null) {
      return 2;
    }
    RoutineScheduleRelationExample example = new RoutineScheduleRelationExample();
    //找出所有序号N之后的，对应当天安排的行程，并以升序排列
    example.setOrderByClause(CommonConstant.SCHEDULE_SERIAL);
    example.createCriteria()
        .andScheduleSerialGreaterThan(N)
        .andRoutineUuidEqualTo(routineUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<RoutineScheduleRelation> relationList = dao.selectByExample(example);

    if (relationList.size() == 0) {
      //直接插在最后一位
      dto.setScheduleSerial(N + 1);
      this.addNewRoutineScheduleRelation(dto);
      return 1;
    } else {
      //从最后一位开始往后挪
      for (int i = relationList.size() - 1; i >= 0; i--) {
        Modify_Routine_Schedule_DTO temp = new Modify_Routine_Schedule_DTO();
        temp.setUuid(relationList.get(i).getUuid());
        temp.setScheduleSerial(relationList.get(i).getScheduleSerial());

        //往后挪一位
        this.scheduleSerialMoveN(temp, 1);
      }
      //插在N+1的位置
      dto.setScheduleSerial(N + 1);
      this.addNewRoutineScheduleRelation(dto);
      return 1;
    }
  }

  /**
   * 将当前行程往前或往后移动N位
   *
   * @param N 往前移动 N < 0；     往后移动 N > 0
   * @return 2:exception;   1:ok;
   */
  public int scheduleSerialMoveN(Modify_Routine_Schedule_DTO modify_routine_schedule_dto,
      Integer N) {
    String uuid = modify_routine_schedule_dto.getUuid();
    Integer serial = modify_routine_schedule_dto.getScheduleSerial();
    if (uuid == null || serial == null || serial + N < 0) {
      return 2;
    }
    this.modifyScheduleSerial(modify_routine_schedule_dto, serial + N);
    return 1;
  }


  @Override
  public int addNewRoutineScheduleRelation(
      Insert_Routine_Schedule_DTO insert_routine_schedule_dto) {

    Integer serial = insert_routine_schedule_dto.getScheduleSerial();
    String scheduleUuid = insert_routine_schedule_dto.getScheduleUuid();
    String routineUuid = insert_routine_schedule_dto.getRoutineUuid();
    String scheduleTypeUuid = insert_routine_schedule_dto.getScheduleTypeUuid();

    Assert.notNull(serial, "serial blank");
    Assert.notBlank(scheduleUuid, "scheduleUuid blank");
    Assert.notBlank(routineUuid, "routineUuid blank");
    Assert.notBlank(scheduleTypeUuid, "scheduleTypeUuid blank");

    RoutineScheduleRelation routineScheduleRelation = new RoutineScheduleRelation(
        IdUtil.randomUUID(), routineUuid, scheduleUuid, scheduleTypeUuid, serial);
    return dao.insertSelective(routineScheduleRelation);
  }


  /**
   * 使用uuid进行索引
   */
  @Override
  public int deleteRoutineScheduleRelation(Query_Routine_Schedule_DTO query_routine_schedule_dto) {
    String uuid = query_routine_schedule_dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    RoutineScheduleRelationExample example = new RoutineScheduleRelationExample();
    example.createCriteria().andUuidEqualTo(uuid).andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<RoutineScheduleRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    RoutineScheduleRelation relation = relationList.get(0);
    relation.setDeleted(CommonConstant.DELETED);
    example.createCriteria().andUuidEqualTo(uuid);
    return dao.updateByExampleSelective(relation, example);
  }

  /**
   * 当前只提供UUID索引，后续根据需求增加由routineUuid+scheduleUuid索引
   */
  public int modifyScheduleSerial(Modify_Routine_Schedule_DTO modify_routine_schedule_dto,
      Integer newScheduleSerial) {
    String uuid = modify_routine_schedule_dto.getUuid();
    if (uuid == null || newScheduleSerial == null) {
      return 2;
    }
    RoutineScheduleRelationExample example = new RoutineScheduleRelationExample();
    example.setLimit(1);
    example.createCriteria().andUuidEqualTo(uuid).andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<RoutineScheduleRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    RoutineScheduleRelation relation = relationList.get(0);
    if (!newScheduleSerial.equals(relation.getScheduleSerial())) {
      relation.setScheduleSerial(newScheduleSerial);
    }

    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(relation, example);
    return 1;
  }

  /**
   * 两个schedule交换序号
   * 使用UUID进行索引
   * @param dto1 schedule1
   * @param dto2 schedule2
   */
  @Transactional
  @Override
  public int exchangeScheduleSerial(
      Modify_Routine_Schedule_DTO dto1,
      Modify_Routine_Schedule_DTO dto2) {
    String uuid1 = dto1.getUuid();
    String uuid2 = dto2.getUuid();
    if (uuid1 == null || uuid2 == null) {
      return 2;
    }
    RoutineScheduleRelationExample example1 = new RoutineScheduleRelationExample();
    example1.setLimit(1);
    example1.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED).andUuidEqualTo(uuid1);
    List<RoutineScheduleRelation> list1 = dao.selectByExample(example1);
    if (list1.size() == 0) {
      return 2;
    }

    RoutineScheduleRelationExample example2 = new RoutineScheduleRelationExample();
    example2.setLimit(1);
    example2.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED).andUuidEqualTo(uuid2);
    List<RoutineScheduleRelation> list2 = dao.selectByExample(example2);
    if (list2.size() == 0) {
      return 2;
    }

    Integer serial1 = list1.get(0).getScheduleSerial();
    Integer serial2 = list2.get(0).getScheduleSerial();

    if (serial1 == null || serial2 == null) {
      return 2;
    }

    //设置中间值，因为serial有唯一索引
    Integer buffer = -1;
    int buffer_result = this.modifyScheduleSerial(dto1, buffer);
    int result2 = this.modifyScheduleSerial(dto2, serial1);
    int result1 = this.modifyScheduleSerial(dto1, serial2);
    return result1 + result2 +buffer_result == 3 ? 1 : 2;
  }


  /**
   * FIXME 不允许自行修改type，只允许修改schedule，系统获取该schedule是否存在，如果存在，则获取其type，并交由系统进行类型修改 本方法已限制修改序列号serial
   */
  @Transactional
  public int modifyRoutineSchedule(Modify_Routine_Schedule_DTO modify_routine_schedule_dto) {
    String uuid = modify_routine_schedule_dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    RoutineScheduleRelationExample example = new RoutineScheduleRelationExample();
    example.createCriteria().andUuidEqualTo(uuid);
    List<RoutineScheduleRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    RoutineScheduleRelation relation = relationList.get(0);

    String scheduleUuid = modify_routine_schedule_dto.getScheduleUuid();
    String routineUuid = modify_routine_schedule_dto.getRoutineUuid();
    String typeUuid = modify_routine_schedule_dto.getScheduleTypeUuid();
    String correctScheduleTypeUuid = "";

    if (Inspections.isNotBlank(scheduleUuid)) {
      // 根据输入的类型，搭配scheduleUuid，找到真正的类型
      switch (typeUuid) {
        case CommonConstant.SCHEDULE_TYPE_DESTINATION:
          correctScheduleTypeUuid = destinationService
              .getScheduleByUUID(scheduleUuid, false).getScheduleType();
          break;
        case CommonConstant.SCHEDULE_TYPE_HOTEL:
          correctScheduleTypeUuid = hotelService.getScheduleByUUID(scheduleUuid, false)
              .getScheduleType();
          break;
        case CommonConstant.SCHEDULE_TYPE_RESTAURANT:
          correctScheduleTypeUuid = restaurantService
              .getScheduleByUUID(scheduleUuid, false).getScheduleType();
          break;
        case CommonConstant.SCHEDULE_TYPE_VEHICLE:
          correctScheduleTypeUuid = vehicleService
              .getScheduleByUUID(scheduleUuid, false).getScheduleType();
          break;
      }
      //若输入的类型和真正的类型有冲突，则匹配失败，返回2
      if (!typeUuid.equals(correctScheduleTypeUuid)) {
        return 2;
      }
      relation.setScheduleUuid(scheduleUuid);
      relation.setScheduleTypeUuid(correctScheduleTypeUuid);
    }
    if (Inspections.isNotBlank(routineUuid)) {
      relation.setRoutineUuid(routineUuid);
    }
    relation.setDeleted(CommonConstant.NOT_DELETED);

    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(relation, example);
    return 1;
  }
}
