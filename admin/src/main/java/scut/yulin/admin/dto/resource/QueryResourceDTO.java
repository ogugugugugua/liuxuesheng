package scut.yulin.admin.dto.resource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.common.dto.PageQueryDTO;

/**
 * @Date 2021/5/23
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor

public class QueryResourceDTO extends PageQueryDTO {
  String uuid;
}
