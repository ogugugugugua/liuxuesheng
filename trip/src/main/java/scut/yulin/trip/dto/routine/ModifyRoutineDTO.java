package scut.yulin.trip.dto.routine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyRoutineDTO extends QueryRoutineDTO{
  String curDate;
  String supplement;
}
