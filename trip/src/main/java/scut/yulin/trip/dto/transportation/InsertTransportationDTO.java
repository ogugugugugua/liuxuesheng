package scut.yulin.trip.dto.transportation;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @date 2021/04/21
 * 插入交通方式DTO
 */
public class InsertTransportationDTO {

  /**
   * 关联行程uuid
   */
  private String scheduleUuid;

  /**
   * 关联行程类型uuid
   */
  private String scheduleTypeUuid;

  /**
   * 交通工具类型uuid
   */
  private String transportationTypeUuid;

  /**
   * 默认价格 【可选】
   */
  private BigDecimal defaultPrice;

  /**
   * 交通工具编号
   */
  private String vehicleNumber;

  /**
   * 乘坐地点 【可选】
   */
  private String boardingLocation;

  /**
   * 创建人uuid
   */
  private String creatorUuid;
}
