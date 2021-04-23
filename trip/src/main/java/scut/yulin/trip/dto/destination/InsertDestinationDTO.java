package scut.yulin.trip.dto.destination;

import java.math.BigDecimal;
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

public class InsertDestinationDTO {

  /**
   * 外文名称
   */
  private String localName;

  /**
   * 中文名称【可选】
   */
  private String cnName;

  /**
   * 所在城市
   */
  private String city;

  /**
   * 所在国家【可选】
   */
  private String countryUuid;

  /**
   * 具体地址
   */
  private String location;

  /**
   * 用户评分【可选】
   */
  private BigDecimal rating;

  /**
   * 预计活动时间【可选】
   */
  private String duration;

  /**
   * 链接网址【可选】
   */
  private String url;

  /**
   * 目的地描述
   */
  private String description;

  /**
   * 特殊要求【可选】
   */
  private String specialRequirement;
}
