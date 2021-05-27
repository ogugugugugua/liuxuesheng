package scut.yulin.admin.dto.traveler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.common.dto.PageQueryDTO;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryTravelerDTO extends PageQueryDTO {

  String uuid;
  String accountName;
}
