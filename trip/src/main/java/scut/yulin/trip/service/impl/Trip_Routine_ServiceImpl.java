package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.routine.QueryRoutineDTO;
import scut.yulin.trip.dto.trip_routine.Insert_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Modify_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Query_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Result_Trip_Routine_DTO;
import scut.yulin.trip.mbg.mapper.TripRoutineRelationDao;
import scut.yulin.trip.model.Routine;
import scut.yulin.trip.model.TripRoutineRelation;
import scut.yulin.trip.model.TripRoutineRelationExample;
import scut.yulin.trip.service.RoutineService;
import scut.yulin.trip.service.Trip_Routine_Service;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class Trip_Routine_ServiceImpl implements Trip_Routine_Service {

  @Autowired
  TripRoutineRelationDao dao;

  @Autowired
  RoutineService routineService;

  @Override
  public List<Result_Trip_Routine_DTO> getRoutineListByTripUUID(
      Query_Trip_Routine_DTO query_trip_routine_dto, Boolean getFullInformation) {
    String tripUuid = query_trip_routine_dto.getTripUuid();
    if (tripUuid == null) {
      return null;
    }
    TripRoutineRelationExample example = new TripRoutineRelationExample();
    example.setLimit(query_trip_routine_dto.getPageSize());
    example.setOffset(query_trip_routine_dto.getOffset());
    example.setOrderByClause(CommonConstant.ROUTINE_SERIAL);
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED)
        .andTripUuidEqualTo(tripUuid);
    List<TripRoutineRelation> relationList = dao.selectByExample(example);

    Integer relationListSize = relationList.size();
    if (relationListSize == 0) {
      return null;
    }

    List<Result_Trip_Routine_DTO> resultList = Collections.synchronizedList(new LinkedList<>());
    for (TripRoutineRelation item : relationList) {
      Result_Trip_Routine_DTO result = new Result_Trip_Routine_DTO();

      Routine routine = routineService
          .getRoutineByUUID(new QueryRoutineDTO(item.getRoutineUuid()), getFullInformation);

      result.setRoutine(routine);
      result.setRelationUuid(item.getUuid());
      result.setTripUuid(item.getTripUuid());
      result.setRoutineSerial(item.getRoutineSerial());
      result.setRoutineListSize(relationListSize);

      resultList.add(result);
    }

    return resultList;
  }


  @Override
  public int deleteTripRoutineRelation(Query_Trip_Routine_DTO query_trip_routine_dto) {
    String uuid = query_trip_routine_dto.getUuid();
    if (uuid == null) {
      return 2;
    }

    TripRoutineRelationExample example = new TripRoutineRelationExample();
    example.createCriteria().andUuidEqualTo(uuid).andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TripRoutineRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    TripRoutineRelation relation = relationList.get(0);
    relation.setDeleted(CommonConstant.DELETED);
    example.createCriteria().andUuidEqualTo(uuid);
    return dao.updateByExampleSelective(relation, example);
  }

  /**
   * @param insert_trip_routine_dto 需要插入的信息以及指定的serial，serial >= 1
   */
  @Override
  @Transactional
  public int addNewTripRoutineRelationAsSerialN(Insert_Trip_Routine_DTO insert_trip_routine_dto) {
    System.out.println("addNewTripRoutineRelationAsSerialN ====> "+insert_trip_routine_dto.toString());
    return this.addRoutineAfterSerialN(insert_trip_routine_dto,
        insert_trip_routine_dto.getRoutineSerial() - 1);
  }

  @Override
  public int modifyTripRoutineRelation(Modify_Trip_Routine_DTO modify_trip_routine_dto) {
    String uuid = modify_trip_routine_dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    TripRoutineRelationExample example = new TripRoutineRelationExample();
    example.setLimit(1);
    example.createCriteria().andUuidEqualTo(uuid);
    List<TripRoutineRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    TripRoutineRelation relation = relationList.get(0);

    String routineUuid = modify_trip_routine_dto.getRoutineUuid();
    String tripUuid = modify_trip_routine_dto.getTripUuid();

    if (Inspections.isNotBlank(routineUuid)) {
      //FIXME: 查看是否存在该routine
      relation.setRoutineUuid(routineUuid);
    }
    if (Inspections.isNotBlank(tripUuid)) {
      //FIXME：查看是否存在该trip
      relation.setTripUuid(tripUuid);
    }
    relation.setDeleted(CommonConstant.NOT_DELETED);

    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(relation, example);
    return 1;
  }

  /**
   * 仅使用UUID进行索引
   * @param modify_trip_routine_dto
   * @return
   */
  @Transactional
  @Override
  public int moveUpOneStep(Modify_Trip_Routine_DTO modify_trip_routine_dto) {
    String uuid = modify_trip_routine_dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    TripRoutineRelationExample example = new TripRoutineRelationExample();
    example.setLimit(1);
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TripRoutineRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    TripRoutineRelation relation = relationList.get(0);
    // 已经在第一位，不能再往上移动，直接返回移动成功
    int curSerial = relation.getRoutineSerial();
    if (curSerial == 1) {
      return 1;
    }

    // 寻找需要移动的上一位受害者
    String tripUuid = relation.getTripUuid();
    example = new TripRoutineRelationExample();
    example.setOrderByClause(CommonConstant.ROUTINE_SERIAL);
    example.createCriteria()
        .andTripUuidEqualTo(tripUuid)
        .andRoutineSerialLessThan(curSerial)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TripRoutineRelation> victimList = dao.selectByExample(example);

    // 已经在第一位，不能再往上移动，直接返回移动成功
    if (victimList.size() == 0) {
      return 1;
    }

    // 找到上一个序号的受害者朋友
    TripRoutineRelation relationToBeMoved = victimList.get(victimList.size() - 1);
    int serialOfRelationToBeMoved = relationToBeMoved.getRoutineSerial();
    int bufferSerial = -1;

    // 把目标relation的serial置为-1
    example = new TripRoutineRelationExample();
    example.createCriteria().andUuidEqualTo(relation.getUuid());
    relation.setRoutineSerial(bufferSerial);
    dao.updateByExampleSelective(relation, example);

    // 把受害者relation的serial置为目标relation的serial，即curSerial
    example = new TripRoutineRelationExample();
    example.createCriteria().andUuidEqualTo(relationToBeMoved.getUuid());
    relationToBeMoved.setRoutineSerial(curSerial);
    dao.updateByExampleSelective(relationToBeMoved,example);

    // 把目标relation的serial置为受害者relation的serial，即serialOfRelationToBeMoved
    example = new TripRoutineRelationExample();
    example.createCriteria().andUuidEqualTo(relation.getUuid());
    relation.setRoutineSerial(serialOfRelationToBeMoved);
    dao.updateByExampleSelective(relation, example);
    return 1;
  }

  /**
   * 仅使用UUID进行索引
   * @param modify_trip_routine_dto
   * @return
   */
  @Transactional
  @Override
  public int moveDownOneStep(Modify_Trip_Routine_DTO modify_trip_routine_dto) {
    String uuid = modify_trip_routine_dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    TripRoutineRelationExample example = new TripRoutineRelationExample();
    example.setLimit(1);
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TripRoutineRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    TripRoutineRelation relation = relationList.get(0);
    int curSerial = relation.getRoutineSerial();


    // 寻找需要移动的上一位受害者
    String tripUuid = relation.getTripUuid();
    example = new TripRoutineRelationExample();
    example.setOrderByClause(CommonConstant.ROUTINE_SERIAL);
    example.createCriteria()
        .andTripUuidEqualTo(tripUuid)
        .andRoutineSerialGreaterThan(curSerial)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TripRoutineRelation> victimList = dao.selectByExample(example);

    // 找不到比它序号更大的项，证明已经在最后一位，不能再往下移动，直接返回移动成功
    if (victimList.size() == 0) {
      return 1;
    }

    // 找到下一个序号的受害者朋友
    TripRoutineRelation relationToBeMoved = victimList.get(0);
    int serialOfRelationToBeMoved = relationToBeMoved.getRoutineSerial();
    int bufferSerial = -1;

    // 把目标relation的serial置为-1
    example = new TripRoutineRelationExample();
    example.createCriteria().andUuidEqualTo(relation.getUuid());
    relation.setRoutineSerial(bufferSerial);
    dao.updateByExampleSelective(relation, example);

    // 把受害者relation的serial置为目标relation的serial，即curSerial
    example = new TripRoutineRelationExample();
    example.createCriteria().andUuidEqualTo(relationToBeMoved.getUuid());
    relationToBeMoved.setRoutineSerial(curSerial);
    dao.updateByExampleSelective(relationToBeMoved,example);

    // 把目标relation的serial置为受害者relation的serial，即serialOfRelationToBeMoved
    example = new TripRoutineRelationExample();
    example.createCriteria().andUuidEqualTo(relation.getUuid());
    relation.setRoutineSerial(serialOfRelationToBeMoved);
    dao.updateByExampleSelective(relation, example);
    return 1;
  }

  private int addRoutineAfterSerialN(Insert_Trip_Routine_DTO dto, Integer N) {
    String tripUuid = dto.getTripUuid();
    if (tripUuid == null) {
      return 2;
    }
    TripRoutineRelationExample example = new TripRoutineRelationExample();
    example.setOrderByClause(CommonConstant.ROUTINE_SERIAL);
    example.createCriteria()
        .andRoutineSerialGreaterThan(N)
        .andTripUuidEqualTo(tripUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TripRoutineRelation> relationList = dao.selectByExample(example);

    if (relationList.size() == 0) {
      //找出这个旅途总共有多少天
      example = new TripRoutineRelationExample();
      example.setOrderByClause(CommonConstant.ROUTINE_SERIAL);
      example.createCriteria()
          .andTripUuidEqualTo(tripUuid)
          .andDeletedEqualTo(CommonConstant.NOT_DELETED);
      List<TripRoutineRelation> list = dao.selectByExample(example);

      int serial;
      //当前日安排为第一个有效日安排
      if (list.size() == 0) {
        serial = 1;
      } else {
        //已有其他日安排，当前日安排为最后一个有效日安排
        serial = list.get(list.size()-1).getRoutineSerial()+1;
      }

      //新dto直接插在最后一位
      dto.setRoutineSerial(serial);
      this.addNewTripRoutineRelation(dto);
      return 1;
    } else {
      //从最后一位开始逐步将N+1以后的数据往后挪
      for (int i = relationList.size() - 1; i >= 0; i--) {
        Modify_Trip_Routine_DTO temp = new Modify_Trip_Routine_DTO();
        temp.setUuid(relationList.get(i).getUuid());
        temp.setRoutineSerial(relationList.get(i).getRoutineSerial());

        //往后挪一位
        this.routineSerialMoveN(temp, 1);
      }

      //新dto插在N+1的位置
      dto.setRoutineSerial(N + 1);
      this.addNewTripRoutineRelation(dto);
      return 1;
    }
  }

  /**
   * 将当日安排往前或往后移动N位，不考虑序号碰撞
   *
   * @param N 往前移动 N < 0；     往后移动 N > 0
   */
  private int routineSerialMoveN(Modify_Trip_Routine_DTO modify_trip_routine_dto, Integer N) {
    String uuid = modify_trip_routine_dto.getUuid();
    Integer routineSerial = modify_trip_routine_dto.getRoutineSerial();
    if (routineSerial == null || uuid == null || routineSerial + N < 0) {
      return 2;
    }
    this.modifyRoutineSerial(modify_trip_routine_dto, routineSerial + N);
    return 1;
  }

  /**
   * 强行把某一行记录的routine的序号改变，而不考虑是否会与原本存在的另一个routine序号发生冲突
   */
  private int modifyRoutineSerial(Modify_Trip_Routine_DTO modify_trip_routine_dto,
      Integer newRoutineSerial) {
    String uuid = modify_trip_routine_dto.getUuid();
    if (uuid == null || newRoutineSerial == null) {
      return 2;
    }
    TripRoutineRelationExample example = new TripRoutineRelationExample();
    example.setLimit(1);
    example.createCriteria().andUuidEqualTo(uuid).andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TripRoutineRelation> relationList = dao.selectByExample(example);
    if (relationList.size() == 0) {
      return 2;
    }

    TripRoutineRelation relation = relationList.get(0);
    if (!newRoutineSerial.equals(relation.getRoutineSerial())) {
      relation.setRoutineSerial(newRoutineSerial);
    }

    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(relation, example);
    return 1;
  }

  private int addNewTripRoutineRelation(Insert_Trip_Routine_DTO insert_trip_routine_dto) {
    Integer routineSerial = insert_trip_routine_dto.getRoutineSerial();
    String routineUuid = insert_trip_routine_dto.getRoutineUuid();
    String tripUuid = insert_trip_routine_dto.getTripUuid();

    Assert.notNull(routineSerial, "routineSerial blank");
    Assert.notBlank(routineUuid, "routineUuid blank");
    Assert.notBlank(tripUuid, "tripUuid blank");

    TripRoutineRelation tripRoutineRelation = new TripRoutineRelation(IdUtil.randomUUID(), tripUuid,
        routineUuid, routineSerial);
    return dao.insertSelective(tripRoutineRelation);
  }
}
