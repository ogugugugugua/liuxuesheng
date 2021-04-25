package scut.yulin.trip.dto.room;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyRoomDTO extends QueryRoomDTO{
  /**
   * 房间类型
   */
  private String type;

  /**
   * 可入住人数
   */
  private Integer numberPerson;

  /**
   * 默认价格
   */
  private BigDecimal defaultPrice;

  /**
   * 折扣价格
   */
  private BigDecimal discountPrice;

  /**
   * 折扣价对应会员等级
   */
  private String vipGrade;
}
