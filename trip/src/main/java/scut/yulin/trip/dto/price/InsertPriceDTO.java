package scut.yulin.trip.dto.price;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/22
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InsertPriceDTO {
  /**
   * 关联行程uuid
   */
  private String scheduleUuid;

  /**
   * 关联行程类型uuid
   */
  private String scheduleTypeUuid;

  /**
   * 价格对应项目名称
   */
  private String name;

  /**
   * 原价
   */
  private BigDecimal originalPrice;

  /**
   * 折扣价
   */
  private BigDecimal discountPrice;

  /**
   * 创建人uuid
   */
  private String creatorUuid;
}
