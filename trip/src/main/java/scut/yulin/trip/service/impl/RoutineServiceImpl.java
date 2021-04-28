package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.routine.InsertRoutineDTO;
import scut.yulin.trip.dto.routine.ModifyRoutineDTO;
import scut.yulin.trip.dto.routine.QueryRoutineDTO;
import scut.yulin.trip.dto.routine_schedule.Query_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Result_Routine_Schedule_DTO;
import scut.yulin.trip.mbg.mapper.RoutineDao;
import scut.yulin.trip.model.Routine;
import scut.yulin.trip.model.RoutineExample;
import scut.yulin.trip.service.RoutineService;
import scut.yulin.trip.service.Routine_Schedule_Service;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class RoutineServiceImpl implements RoutineService {
  private static final SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");//如2016-08-10 20:40

  @Autowired
  RoutineDao routineDao;

  @Autowired
  Routine_Schedule_Service scheduleService;

  @Override
  public List<Routine> getRoutineList(QueryRoutineDTO queryRoutineDTO) {
    RoutineExample example = new RoutineExample();
    example.setLimit(queryRoutineDTO.getPageSize());
    example.setOffset(queryRoutineDTO.getOffset());
    example.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);

    return routineDao.selectByExample(example);
  }

  @Override
  public Routine getRoutineByUUID(QueryRoutineDTO queryRoutineDTO, Boolean getFullInformation) {
    String uuid = queryRoutineDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    RoutineExample example = new RoutineExample();
    example.setLimit(1);
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<Routine> routineList = routineDao.selectByExample(example);
    if (routineList.size() == 0) {
      return null;
    }

    Routine routine = routineList.get(0);
//    if (getFullInformation) {
      List<Result_Routine_Schedule_DTO> scheduleList = scheduleService
          .getScheduleListByRoutineUUID(new Query_Routine_Schedule_DTO(routine.getUuid(), null),
              getFullInformation);
      routine.setScheduleList(scheduleList);
//    }
    return routine;
  }

  @Override
  public int addNewRoutine(InsertRoutineDTO insertRoutineDTO) {
    String supplement = insertRoutineDTO.getSupplement();
    String curDate = insertRoutineDTO.getCurDate();

    Date currentDate;
    try {
      currentDate = simpleFormat.parse(curDate);
    } catch (ParseException e) {
      e.printStackTrace();
      return 3;
    }
    Assert.notNull(currentDate,"currentDate blank");
    Routine routine = new Routine(IdUtil.randomUUID(), supplement, currentDate);
    routineDao.insertSelective(routine);
    return 1;
  }

  @Override
  public int deleteRoutine(QueryRoutineDTO queryRoutineDTO) {
    String uuid = queryRoutineDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    Routine routine = this.getRoutineByUUID(queryRoutineDTO, false);
    if (routine == null) {
      return 2;
    }
    routine.setDeleted(CommonConstant.DELETED);
    RoutineExample example = new RoutineExample();
    example.createCriteria().andUuidEqualTo(uuid);

    routineDao.updateByExampleSelective(routine, example);
    return 1;
  }

  private Routine getRoutineByUUIDWithDeleted(QueryRoutineDTO queryRoutineDTO) {
    String uuid = queryRoutineDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    RoutineExample example = new RoutineExample();
    example.setLimit(1);
    example.createCriteria()
        .andUuidEqualTo(uuid);

    List<Routine> routineList = routineDao.selectByExample(example);
    if (routineList.size() == 0) {
      return null;
    }
    return routineList.get(0);
  }

  /**
   * 根据uuid进行索引来修改routine
   * @param modifyRoutineDTO
   * @return 1:ok   2:not found   3:parse error
   */
  @Override
  public int modifyRoutine(ModifyRoutineDTO modifyRoutineDTO) {
    String uuid = modifyRoutineDTO.getUuid();
    System.out.println(uuid+"======>uuid");
    if (uuid == null) {
      return 2;
    }
    Routine routine = this.getRoutineByUUIDWithDeleted(modifyRoutineDTO);
    System.out.println(routine);

    if (routine == null) {
      return 2;
    }
    String supplement = modifyRoutineDTO.getSupplement();
    String curDate = modifyRoutineDTO.getCurDate();

    if (Inspections.isNotBlank(supplement)) {
      routine.setSupplement(supplement);
    }
    if (Inspections.isNotBlank(curDate)) {
      Date curentDate;
      try {
         curentDate = simpleFormat.parse(curDate);
      } catch (ParseException e) {
        e.printStackTrace();
        return 3;
      }
      Assert.notNull(curentDate,"currentDate parse error");
      routine.setCurDate(curentDate);
    }
    routine.setDeleted(CommonConstant.NOT_DELETED);

    RoutineExample example = new RoutineExample();
    example.createCriteria().andUuidEqualTo(uuid);
    routineDao.updateByExampleSelective(routine, example);
    return 1;
  }
}
