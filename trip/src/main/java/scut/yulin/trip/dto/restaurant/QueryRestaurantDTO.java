package scut.yulin.trip.dto.restaurant;

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
@NoArgsConstructor
@AllArgsConstructor
public class QueryRestaurantDTO extends PageQueryDTO {
  private String uuid;
}
