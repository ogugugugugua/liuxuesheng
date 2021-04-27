package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.routine_schedule.Insert_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Modify_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Query_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Result_Routine_Schedule_DTO;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
public interface Routine_Schedule_Service {
  public List<Result_Routine_Schedule_DTO> getScheduleListByRoutineUUID(
      Query_Routine_Schedule_DTO query_routine_schedule_dto, Boolean getFullInformation);

  public int addNewRoutineScheduleRelation(Insert_Routine_Schedule_DTO insert_routine_schedule_dto);

  public int deleteRoutineScheduleRelation(Query_Routine_Schedule_DTO query_routine_schedule_dto);

  public int modifyScheduleSerial(Modify_Routine_Schedule_DTO modify_routine_schedule_dto);
}
