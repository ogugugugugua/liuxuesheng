package scut.yulin.trip.dto.routine_schedule;

import io.swagger.annotations.ApiModelProperty;
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
  @ApiModelProperty(value = "行uuid")
  String relationUuid;

  @ApiModelProperty(value = "日安排uuid")
  String routineUuid;

  @ApiModelProperty(value = "当前行程所在排序序号")
  Integer scheduleSerial;

  @ApiModelProperty(value = "当日行程数量")
  Integer scheduleListSize;

  @ApiModelProperty(value = "当前行程详情")
  Schedule schedule;
}
