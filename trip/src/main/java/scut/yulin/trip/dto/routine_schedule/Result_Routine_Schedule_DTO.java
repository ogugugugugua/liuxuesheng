package scut.yulin.trip.dto.routine_schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.model.Schedule;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result_Routine_Schedule_DTO {
  String routineUuid;
  Integer scheduleSerial;
  String relationUuid;
  Schedule schedule;
}
