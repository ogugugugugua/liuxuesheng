package scut.yulin.trip.dto.hotel;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InsertHotelDTO {
  /**
   * 星级 必选
   */
  private Integer stars;

  /**
   * 外文名称 必选
   */
  private String localName;

  /**
   * 中文名称
   */
  private String cnName;

  /**
   * 所在城市 必选
   */
  private String city;

  /**
   * 所在国家
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

  /**
   * 最早入住时间 必选
   */
  private String checkInTime;

  /**
   * 最晚离开时间 必选
   */
  private String checkOutTime;

  /**
   * 酒店描述
   */
  private String description;

  /**
   * 酒店类型
   */
  private String type;

  /**
   * 建成年份
   */
  private String builtYear;

  /**
   * 酒店规模
   */
  private Integer scale;

  /**
   * 预订取消政策
   */
  private String cancelPolicy;

  /**
   * 保留字段
   */
  private String remark;
  //
}
