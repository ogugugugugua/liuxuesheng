package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.routine.InsertRoutineDTO;
import scut.yulin.trip.dto.routine.ModifyRoutineDTO;
import scut.yulin.trip.dto.routine.QueryRoutineDTO;
import scut.yulin.trip.model.Routine;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
public interface RoutineService {
  public List<Routine> getRoutineList(QueryRoutineDTO queryRoutineDTO);

  public Routine getRoutineByUUID(QueryRoutineDTO queryRoutineDTO, Boolean getFullInformation);

  public int addNewRoutine(InsertRoutineDTO insertRoutineDTO);

  public int deleteRoutine(QueryRoutineDTO queryRoutineDTO);

  public int modifyRoutine(ModifyRoutineDTO modifyRoutineDTO);
}
