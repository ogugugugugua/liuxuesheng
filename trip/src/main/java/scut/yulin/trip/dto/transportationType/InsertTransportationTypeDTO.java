package scut.yulin.trip.dto.transportationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
 * @date 2021/04/21
 * 插入交通类型DTO
 */
public class InsertTransportationTypeDTO {

  /**
   * 类型
   */
  private String type;

  /**
   * 中文名
   */
  private String cnName;

  /**
   * 创建人uuid
   */
  private String creatorUuid;
}
