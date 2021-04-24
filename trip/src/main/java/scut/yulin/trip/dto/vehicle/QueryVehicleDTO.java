package scut.yulin.trip.dto.vehicle;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.dto.PageQueryDTO;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class QueryVehicleDTO extends PageQueryDTO {
  String uuid;

}
