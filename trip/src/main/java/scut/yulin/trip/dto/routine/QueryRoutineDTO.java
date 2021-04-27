package scut.yulin.trip.dto.routine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.dto.PageQueryDTO;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryRoutineDTO extends PageQueryDTO {
  String uuid;
}
