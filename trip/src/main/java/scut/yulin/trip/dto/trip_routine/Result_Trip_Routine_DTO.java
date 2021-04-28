package scut.yulin.trip.dto.trip_routine;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.model.Routine;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result_Trip_Routine_DTO {

  @ApiModelProperty(value = "行uuid")
  String relationUuid;

  @ApiModelProperty(value = "旅途uuid")
  String tripUuid;

  @ApiModelProperty(value = "当前日安排所在旅途中的排序序号")
  Integer routineSerial;

  @ApiModelProperty(value = "当前旅途的天数")
  Integer routineListSize;

  @ApiModelProperty(value = "当前日安排")
  Routine routine;
}
