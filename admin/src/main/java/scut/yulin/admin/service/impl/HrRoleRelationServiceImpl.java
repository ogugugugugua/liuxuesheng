package scut.yulin.admin.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.hr_role.InsertHrRoleRelationDTO;
import scut.yulin.admin.dto.hr_role.ModifyHrRoleRelationDTO;
import scut.yulin.admin.dto.hr_role.QueryHrRoleRelationDTO;
import scut.yulin.admin.dto.role.QueryRoleDTO;
import scut.yulin.admin.service.HrRoleRelationService;
import scut.yulin.admin.service.RoleService;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.mbg.mbg.mapper.HrRoleDao;
import scut.yulin.mbg.model.HrRole;
import scut.yulin.mbg.model.HrRoleExample;
import scut.yulin.mbg.model.Resource;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class HrRoleRelationServiceImpl implements HrRoleRelationService {

  @Autowired
  private HrRoleDao dao;

  @Autowired
  private RoleService roleService;

  /**
   * 根据用户UUID找到其具有的资源列表
   * 横跨「用户_角色」--「角色」--「角色_资源」--「资源」
   *
   * @param queryHrRoleRelationDTO 入参为用户UUID
   * @return 该用户的资源列表
   */
  @Override
  public List<Resource> getResourceListByHrUUID(QueryHrRoleRelationDTO queryHrRoleRelationDTO) {
    String hrUuid = queryHrRoleRelationDTO.getHrUuid();
    if (hrUuid == null) {
      return null;
    }
    HrRoleExample example = new HrRoleExample();
    example.createCriteria()
        .andHrUuidEqualTo(hrUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<HrRole> hrRoleRelations = dao.selectByExample(example);
    if (hrRoleRelations.size() == 0) {
      return null;
    }

    List<Resource> result = new ArrayList<>();
    for (HrRole hrRoleRelation : hrRoleRelations) {
      List<Resource> resourceListPerRole = roleService
          .getResourceListByRoleUUID(new QueryRoleDTO(hrRoleRelation.getRoleUuid()));
      result.addAll(resourceListPerRole);
    }
    return result;
  }

  @Override
  public HrRole getHrRoleRelationByUUID(QueryHrRoleRelationDTO queryHrRoleRelationDTO) {
    String uuid = queryHrRoleRelationDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    HrRoleExample example = new HrRoleExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<HrRole> hrRoleList = dao.selectByExample(example);
    if (hrRoleList.size() > 0) {
      return hrRoleList.get(0);
    }
    return null;
  }

  @Override
  public List<HrRole> getHrRoleRelationList(QueryHrRoleRelationDTO queryHrRoleRelationDTO) {
    HrRoleExample example = new HrRoleExample();
    example.setLimit(queryHrRoleRelationDTO.getPageSize());
    example.setOffset(queryHrRoleRelationDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return dao.selectByExample(example);
  }

  @Override
  public int addNewHrRoleRelation(InsertHrRoleRelationDTO insertHrRoleRelationDTO) {
    Assert.notBlank(insertHrRoleRelationDTO.getHrUuid(),"hrUuid");
    Assert.notBlank(insertHrRoleRelationDTO.getRoleUuid(),"roleUuid");
    dao.insertSelective(
        new HrRole(IdUtil.randomUUID(), insertHrRoleRelationDTO.getHrUuid(),
            insertHrRoleRelationDTO.getRoleUuid()));
    return 1;
  }

  @Override
  public int deleteHrRoleRelationByUUID(QueryHrRoleRelationDTO queryHrRoleRelationDTO) {
    String uuid = queryHrRoleRelationDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    HrRole hrRoleRelation = this.getHrRoleRelationByUUID(queryHrRoleRelationDTO);

    if (hrRoleRelation == null) {
      return 2;
    }
    hrRoleRelation.setDeleted(CommonConstant.DELETED);
    HrRoleExample example = new HrRoleExample();
    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(hrRoleRelation, example);
    return 1;
  }

  @Override
  public int modifyHrRoleRelation(ModifyHrRoleRelationDTO modifyHrRoleRelationDTO) {
      String uuid = modifyHrRoleRelationDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
    HrRole hrRoleRelation = this.getHrRoleRelationByUUID(modifyHrRoleRelationDTO);

    if (hrRoleRelation == null) {
        return 2;
      }
      if (Inspections.isNotBlank(modifyHrRoleRelationDTO.getHrUuid())) {
        hrRoleRelation.setHrUuid(modifyHrRoleRelationDTO.getHrUuid());
      }
      if (Inspections.isNotBlank(modifyHrRoleRelationDTO.getRoleUuid())) {
        hrRoleRelation.setRoleUuid(modifyHrRoleRelationDTO.getRoleUuid());
      }
      HrRoleExample example = new HrRoleExample();
      example.createCriteria().andUuidEqualTo(uuid);
      dao.updateByExampleSelective(hrRoleRelation, example);
      return 1;
  }
}
