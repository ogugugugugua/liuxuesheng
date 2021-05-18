package scut.yulin.trip.dto.price;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import scut.yulin.common.dto.PageQueryDTO;

/**
 * @Date 2021/4/22
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QueryPriceDTO extends PageQueryDTO {
  String uuid;
  /**
   * 关联行程uuid
   */
  private String scheduleUuid;

  /**
   * 关联行程类型uuid
   */
  private String scheduleTypeUuid;

  /**
   * 创建人uuid
   */
  private String creatorUuid;
}
