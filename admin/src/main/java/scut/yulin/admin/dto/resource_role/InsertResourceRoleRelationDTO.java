package scut.yulin.admin.dto.resource_role;

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
public class InsertResourceRoleRelationDTO {
  /**
   * 资源uuid
   */
  private String resourceUuid;

  /**
   * 角色uuid
   */
  private String roleUuid;

}
