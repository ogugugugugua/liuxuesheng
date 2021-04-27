package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
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
    if (relationList.size() == 0) {
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

      resultList.add(result);
    }
    return resultList;
  }

  @Override
  public int addNewRoutineScheduleRelation(
      Insert_Routine_Schedule_DTO insert_routine_schedule_dto) {

    System.out.println(
        "addNewRoutineScheduleRelation service ===>>" + insert_routine_schedule_dto.toString());

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
   * FIXME 不允许自行修改type，只允许修改schedule，系统获取该schedule是否存在，如果存在，则获取其type，并交由系统进行类型修改
   */
  @Override
  public int modifyScheduleSerial(Modify_Routine_Schedule_DTO modify_routine_schedule_dto) {
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

    Integer scheduleSerial = modify_routine_schedule_dto.getScheduleSerial();
    String scheduleUuid = modify_routine_schedule_dto.getScheduleUuid();
    String routineUuid = modify_routine_schedule_dto.getRoutineUuid();
    String scheduleTypeUuid = modify_routine_schedule_dto.getScheduleTypeUuid();

    if (Inspections.isNotBlank(scheduleTypeUuid)) {
      relation.setScheduleTypeUuid(scheduleTypeUuid);
    }
    if (Inspections.isNotBlank(scheduleUuid)) {
      relation.setScheduleUuid(scheduleUuid);
    }
    if (Inspections.isNotBlank(routineUuid)) {
      relation.setRoutineUuid(routineUuid);
    }
    if (Inspections.isNotEmpty(scheduleSerial)) {
      relation.setScheduleSerial(scheduleSerial);
    }
    relation.setDeleted(CommonConstant.NOT_DELETED);

    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(relation, example);
    return 1;
  }
}
