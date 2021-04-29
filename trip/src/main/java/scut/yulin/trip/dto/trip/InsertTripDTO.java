package scut.yulin.trip.dto.trip;

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
public class InsertTripDTO {
  /**
   * 创建人uuid
   */
  private String creatorUuid;

  /**
   * 标题
   */
  private String title;

  /**
   * 简介
   */
  private String description;

  /**
   * 旅途分类
   */
  private String classification;

  /**
   * 出发时间
   */
  private String departTime;

  /**
   * 出行天数
   */
  private Integer duration;

  /**
   * 置顶 yes:1,no:0
   */
  private String rankTop;

  /**
   * 审核状态 passed:1,other:0
   */
  private String status;

  /**
   * 是否私密行程 私密是1,公开是0
   */
  private String privateTrip;

  /**
   * 是否原创 原创是1,非原创是0
   */
  private String original;
}
