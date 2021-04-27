package scut.yulin.trip.dto.routine_schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.dto.PageQueryDTO;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query_Routine_Schedule_DTO extends PageQueryDTO {
  String routineUuid;
  String uuid;
}
