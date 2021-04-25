package scut.yulin.trip.dto.equipment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsertEquipmentDTO {
  /**
   * 房间uuid
   */
  private String roomUuid;

  /**
   * 设施名字
   */
  private String equipmentName;

  /**
   * 参数
   */
  private String parameter;

  /**
   * 房间里该床型数量
   */
  private Integer quantity;
}
