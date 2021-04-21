package scut.yulin.trip.dto.transportation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.dto.PageQueryDTO;

/**
 * 查询单条或所有可用交通方式DTO
 * 2021/04/21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryTransportationDTO extends PageQueryDTO {
  String uuid;
}
