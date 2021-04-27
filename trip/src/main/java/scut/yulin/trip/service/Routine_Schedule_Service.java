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

  /**
   * 将新的schedule插入到N+1的位置
   * @param dto
   * @param N N>=0
   * @return
   */
  public int addScheduleAfterSerialN(Insert_Routine_Schedule_DTO dto, Integer N);

  /**
   * 将两个schedule位置进行互换
   * 使用UUID进行索引
   * @param dto1
   * @param dto2
   * @return
   */
  public int exchangeScheduleSerial(Modify_Routine_Schedule_DTO dto1,
      Modify_Routine_Schedule_DTO dto2);

  /**
   * 更改routineUuid或者scheduleUuid，需要指定正确的scheduleTypeUuid
   * @param modify_routine_schedule_dto
   * @return
   */
  public int modifyRoutineSchedule(Modify_Routine_Schedule_DTO modify_routine_schedule_dto);
}
