package scut.yulin.trip.dto.destination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/23
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransactionalInsertDestinationDTO extends InsertDestinationDTO{
  /**
   * 某一天uuid
   */
  private String routineUuid;

  /**
   * 该行程序号 用于排序
   */
  private Integer scheduleSerial;
}
