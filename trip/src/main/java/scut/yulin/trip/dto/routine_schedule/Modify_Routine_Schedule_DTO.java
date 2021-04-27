package scut.yulin.trip.dto.routine_schedule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modify_Routine_Schedule_DTO extends Query_Routine_Schedule_DTO {

  /**
   * 某一天uuid
   */
  private String routineUuid;

  /**
   * 当天某行程uuid
   */
  private String scheduleUuid;

  /**
   * 该行程类型uuid
   */
  private String scheduleTypeUuid;

  /**
   * 该行程序号 用于排序
   */
  private Integer scheduleSerial;
}
