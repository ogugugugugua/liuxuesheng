package scut.yulin.trip.dto.bed;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyBedDTO extends QueryBedDTO{
  /**
   * 房间uuid
   */
  private String roomUuid;

  /**
   * 类型 双人床,单人床,沙发床,榻榻米
   */
  private String type;

  /**
   * 该床型可容纳人数
   */
  private Integer numberPerson;

  /**
   * 房间里该床型数量
   */
  private Integer quantity;
}
