package scut.yulin.admin.dto.hr_role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModifyHrRoleRelationDTO extends QueryHrRoleRelationDTO{
  /**
   * 用户uuid
   */
  private String hrUuid;

  /**
   * 角色uuid
   */
  private String roleUuid;
}
