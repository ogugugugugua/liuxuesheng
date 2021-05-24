package scut.yulin.admin.service;

import java.util.List;
import scut.yulin.admin.dto.resource_role.InsertResourceRoleRelationDTO;
import scut.yulin.admin.dto.resource_role.ModifyResourceRoleRelationDTO;
import scut.yulin.admin.dto.resource_role.QueryResourceRoleRelationDTO;
import scut.yulin.admin.model.Resource;
import scut.yulin.admin.model.ResourceRole;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description 角色-资源关联service
 **/
public interface ResourceRoleRelationService {
  /**
   * 根据角色uuid获得其对应的资源列表
   */
  List<Resource> getResourceListByRoleUUID(QueryResourceRoleRelationDTO queryResourceRoleRelationDTO);

  ResourceRole getResourceRoleRelationByUUID(QueryResourceRoleRelationDTO queryResourceRoleRelationDTO);

  List<ResourceRole> getResourceRoleRelationList(QueryResourceRoleRelationDTO queryResourceRoleRelationDTO);

  int addNewResourceRoleRelation(InsertResourceRoleRelationDTO insertResourceRoleRelationDTO);

  int deleteResourceRoleRelationByUUID(QueryResourceRoleRelationDTO queryResourceRoleRelationDTO);

  int modifyResourceRoleRelation(ModifyResourceRoleRelationDTO modifyResourceRoleRelationDTO);
}
