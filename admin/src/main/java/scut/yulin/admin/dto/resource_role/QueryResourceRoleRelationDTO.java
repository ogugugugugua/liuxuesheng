package scut.yulin.admin.dto.resource_role;

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
public class QueryResourceRoleRelationDTO extends PageQueryDTO {

  /**
   * 行记录uuid
   */
  String uuid;

  /**
   * 角色uuid
   */
  String roleUuid;
}
