package scut.yulin.trip.dto.trip_routine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.common.dto.PageQueryDTO;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query_Trip_Routine_DTO extends PageQueryDTO {
  String uuid;
  String tripUuid;
}
