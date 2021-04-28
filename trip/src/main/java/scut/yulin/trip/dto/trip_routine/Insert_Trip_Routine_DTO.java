package scut.yulin.trip.dto.trip_routine;

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
public class Insert_Trip_Routine_DTO {
  /**
   * 某个旅途uuid
   */
  private String tripUuid;

  /**
   * 旅途中某一天uuid
   */
  private String routineUuid;

  /**
   * 该天是第几天 用于排序
   */
  private Integer routineSerial;
}
