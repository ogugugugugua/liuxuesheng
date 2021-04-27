package scut.yulin.trip.service.impl;

import java.util.List;
import scut.yulin.trip.dto.routine.InsertRoutineDTO;
import scut.yulin.trip.dto.routine.ModifyRoutineDTO;
import scut.yulin.trip.dto.routine.QueryRoutineDTO;
import scut.yulin.trip.model.Routine;
import scut.yulin.trip.service.RoutineService;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
public class RoutineServiceImpl implements RoutineService {

  @Override
  public List<Routine> getRoutineList(QueryRoutineDTO queryRoutineDTO) {
    return null;
  }

  @Override
  public Routine getRoutineByUUID(QueryRoutineDTO queryRoutineDTO, Boolean getFullInformation) {
    return null;
  }

  @Override
  public int addNewRoutine(InsertRoutineDTO insertRoutineDTO) {
    return 0;
  }

  @Override
  public int deleteRoutine(QueryRoutineDTO queryRoutineDTO) {
    return 0;
  }

  @Override
  public int modifyRoutine(ModifyRoutineDTO modifyRoutineDTO) {
    return 0;
  }
}
