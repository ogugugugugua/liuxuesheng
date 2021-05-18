package scut.yulin.trip.dto.transportationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.common.dto.PageQueryDTO;

/**
 * 查询单条或所有可用交通方式类型DTO
 * 2021/04/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryTransportationTypeDTO extends PageQueryDTO {
  String uuid;
}
