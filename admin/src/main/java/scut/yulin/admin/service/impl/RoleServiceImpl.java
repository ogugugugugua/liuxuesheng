package scut.yulin.admin.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.resource_role.QueryResourceRoleRelationDTO;
import scut.yulin.admin.dto.role.InsertRoleDTO;
import scut.yulin.admin.dto.role.ModifyRoleDTO;
import scut.yulin.admin.dto.role.QueryRoleDTO;
import scut.yulin.admin.mbg.mapper.RoleDao;
import scut.yulin.admin.model.Resource;
import scut.yulin.admin.model.Role;
import scut.yulin.admin.model.RoleExample;
import scut.yulin.admin.service.ResourceRoleRelationService;
import scut.yulin.admin.service.RoleService;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

  @Autowired
  private RoleDao roleDao;
  @Autowired
  private ResourceRoleRelationService resourceRoleRelationService;

  /**
   * 根据角色uuid获得其对应的资源列表
   */
  @Override
  public List<Resource> getResourceListByRoleUUID(QueryRoleDTO queryRoleDTO) {
    return resourceRoleRelationService
        .getResourceListByRoleUUID(new QueryResourceRoleRelationDTO(null, queryRoleDTO.getUuid()));
  }

  @Override
  public Role getRoleByUUID(QueryRoleDTO queryRoleDTO) {
    String uuid = queryRoleDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    RoleExample example = new RoleExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Role> roleList = roleDao.selectByExample(example);
    if (roleList.size() > 0) {
      Role role = roleList.get(0);
      role.setResourceList(resourceRoleRelationService
          .getResourceListByRoleUUID(new QueryResourceRoleRelationDTO(null, uuid)));
      return role;
    }
    return null;
  }

  @Override
  public List<Role> getRoleList(QueryRoleDTO queryRoleDTO) {
    RoleExample example = new RoleExample();
    example.setLimit(queryRoleDTO.getPageSize());
    example.setOffset(queryRoleDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return roleDao.selectByExample(example);
  }

  @Override
  public int addNewRole(InsertRoleDTO insertRoleDTO) {
    String name = insertRoleDTO.getName();
    Assert.notBlank(name, "name not found");
    String namezh = insertRoleDTO.getNamezh();
    Assert.notBlank(namezh, "namezh not found");
    String description = insertRoleDTO.getDescription();
    Assert.notBlank(description, "description not found");
    roleDao.insertSelective(
        new Role(IdUtil.randomUUID(), name, namezh, description, insertRoleDTO.getCount(),
            insertRoleDTO.getSort(), insertRoleDTO.getStatus()));
    return 1;
  }

  @Override
  public int deleteRole(QueryRoleDTO queryRoleDTO) {
    String uuid = queryRoleDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    Role role = this.getRoleByUUID(queryRoleDTO);
    if (role == null) {
      return 2;
    }
    role.setDeleted(CommonConstant.DELETED);
    RoleExample example = new RoleExample();
    example.createCriteria().andUuidEqualTo(uuid);
    roleDao.updateByExampleSelective(role, example);
    return 1;
  }

  @Override
  public int modifyRole(ModifyRoleDTO modifyRoleDTO) {
    String uuid = modifyRoleDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    Role role = this.getRoleByUUID(modifyRoleDTO);
    if (role == null) {
      return 2;
    }
    if (Inspections.isNotBlank(modifyRoleDTO.getName())) {
      modifyRoleDTO.setName(modifyRoleDTO.getName());
    }
    if (Inspections.isNotBlank(modifyRoleDTO.getNamezh())) {
      modifyRoleDTO.setNamezh(modifyRoleDTO.getNamezh());
    }
    if (Inspections.isNotBlank(modifyRoleDTO.getDescription())) {
      modifyRoleDTO.setDescription(modifyRoleDTO.getDescription());
    }
    if (Inspections.isNotEmpty(modifyRoleDTO.getCount())) {
      modifyRoleDTO.setCount(modifyRoleDTO.getCount());
    }
    if (Inspections.isNotEmpty(modifyRoleDTO.getSort())) {
      modifyRoleDTO.setSort(modifyRoleDTO.getSort());
    }
    if (Inspections.isNotBlank(modifyRoleDTO.getStatus())) {
      modifyRoleDTO.setStatus(modifyRoleDTO.getStatus());
    }

    RoleExample example = new RoleExample();
    example.createCriteria().andUuidEqualTo(uuid);
    roleDao.updateByExampleSelective(role, example);

    return 1;
  }
}
