package scut.yulin.trip.dto.restaurant;

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
@NoArgsConstructor
@AllArgsConstructor
public class ModifyRestaurantDTO extends QueryRestaurantDTO{
  /**
   * 星级
   */
  private Integer stars;

  /**
   * 外文名称
   */
  private String localName;

  /**
   * 中文名称
   */
  private String cnName;

  /**
   * 所在城市
   */
  private String city;

  /**
   * 所在国家uuid
   */
  private String countryUuid;

  /**
   * 具体地址
   */
  private String location;

  /**
   * 用户评分
   */
  private BigDecimal rating;

  /**
   * 链接网址
   */
  private String url;
}
