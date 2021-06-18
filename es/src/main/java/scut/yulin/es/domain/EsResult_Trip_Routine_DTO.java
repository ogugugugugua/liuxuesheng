package scut.yulin.es.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EsResult_Trip_Routine_DTO {

  @ApiModelProperty(value = "行uuid")
  String relationUuid;

  @ApiModelProperty(value = "旅途uuid")
  String tripUuid;

  @ApiModelProperty(value = "当前日安排所在旅途中的排序序号")
  Integer routineSerial;

  @ApiModelProperty(value = "当前旅途的天数")
  Integer routineListSize;

  @ApiModelProperty(value = "当前日安排")
  EsRoutine routine;
}
