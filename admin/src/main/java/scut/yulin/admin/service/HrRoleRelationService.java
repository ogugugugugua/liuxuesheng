package scut.yulin.admin.service;

import java.util.List;
import scut.yulin.admin.dto.hr_role.InsertHrRoleRelationDTO;
import scut.yulin.admin.dto.hr_role.ModifyHrRoleRelationDTO;
import scut.yulin.admin.dto.hr_role.QueryHrRoleRelationDTO;
import scut.yulin.mbg.model.HrRole;
import scut.yulin.mbg.model.Resource;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
public interface HrRoleRelationService {
  /**
   * 根据用户UUID找到其具有的资源列表
   * 横跨「用户_角色」--「角色」--「角色_资源」--「资源」
   *
   * @param queryHrRoleRelationDTO 入参为用户UUID
   * @return 该用户的资源列表
   */
  List<Resource> getResourceListByHrUUID(QueryHrRoleRelationDTO queryHrRoleRelationDTO);

  HrRole getHrRoleRelationByUUID(
      QueryHrRoleRelationDTO queryHrRoleRelationDTO);

  List<HrRole> getHrRoleRelationList(QueryHrRoleRelationDTO queryHrRoleRelationDTO);

  int addNewHrRoleRelation(InsertHrRoleRelationDTO insertHrRoleRelationDTO);

  int deleteHrRoleRelationByUUID(QueryHrRoleRelationDTO queryHrRoleRelationDTO);

  int modifyHrRoleRelation(ModifyHrRoleRelationDTO modifyHrRoleRelationDTO);

}
