package scut.yulin.trip.dto.menu;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertMenuDTO {

  /**
   * 餐厅uuid
   */
  private String restaurantUuid;

  /**
   * 菜名
   */
  private String name;

  /**
   * 描述 【可选】
   */
  private String description;

  /**
   * 价格 【可选】
   */
  private BigDecimal price;
}
