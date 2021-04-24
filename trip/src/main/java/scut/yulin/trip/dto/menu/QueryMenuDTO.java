package scut.yulin.trip.dto.menu;

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

public class QueryMenuDTO extends PageQueryDTO {
  String uuid;

  String restaurantUuid;
}
