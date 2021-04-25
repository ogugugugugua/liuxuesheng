package scut.yulin.trip.dto.vehicle;

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
public class InsertVehicleDTO {

  /**
   * 交通工具类型
   */
  private String transportationTypeUuid;

  /**
   * 外文名称
   */
  private String localName;

  /**
   * 中文名称【可选】
   */
  private String cnName;

  /**
   * 交通工具编号【可选】
   */
  private String vehicleSerial;

  /**
   * 出发时间
   */
  private String departureTime;

  /**
   * 到达时间
   */
  private String arrivalTime;

  /**
   * 出发地点【可选】
   */
  private String departureLocation;

  /**
   * 到达地点【可选】
   */
  private String arrivalLocation;

  /**
   * 舱位等级【可选】
   */
  private String grade;

}
