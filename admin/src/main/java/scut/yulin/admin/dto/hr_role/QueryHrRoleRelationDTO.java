package scut.yulin.admin.dto.hr_role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.common.dto.PageQueryDTO;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryHrRoleRelationDTO extends PageQueryDTO {

  /**
   * 用户UUID
   */
  String hrUuid;

  /**
   * 行记录UUID
   */
  String uuid;
}
