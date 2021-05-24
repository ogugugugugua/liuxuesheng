package scut.yulin.admin.service;

import java.util.List;
import scut.yulin.admin.dto.role.InsertRoleDTO;
import scut.yulin.admin.dto.role.ModifyRoleDTO;
import scut.yulin.admin.dto.role.QueryRoleDTO;
import scut.yulin.admin.model.Resource;
import scut.yulin.admin.model.Role;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
public interface RoleService {
  /**
   * 根据角色uuid获得其对应的资源列表
   */
  List<Resource> getResourceListByRoleUUID(QueryRoleDTO queryRoleDTO);

  Role getRoleByUUID(QueryRoleDTO queryRoleDTO);

  List<Role> getRoleList(QueryRoleDTO queryRoleDTO);

  int addNewRole(InsertRoleDTO insertRoleDTO);

  int deleteRole(QueryRoleDTO queryRoleDTO);

  int modifyRole(ModifyRoleDTO modifyRoleDTO);
}
