package scut.yulin.admin.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.resource.QueryResourceDTO;
import scut.yulin.admin.dto.resource_role.InsertResourceRoleRelationDTO;
import scut.yulin.admin.dto.resource_role.ModifyResourceRoleRelationDTO;
import scut.yulin.admin.dto.resource_role.QueryResourceRoleRelationDTO;
import scut.yulin.admin.mbg.mapper.ResourceRoleDao;
import scut.yulin.admin.model.Resource;
import scut.yulin.admin.model.ResourceRole;
import scut.yulin.admin.model.ResourceRoleExample;
import scut.yulin.admin.service.ResourceRoleRelationService;
import scut.yulin.admin.service.ResourceService;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class ResourceRoleRelationServiceImpl implements ResourceRoleRelationService {

  @Autowired
  private ResourceService resourceService;
  @Autowired
  private ResourceRoleDao dao;

  @Override
  public ResourceRole getResourceRoleRelationByUUID(
      QueryResourceRoleRelationDTO queryResourceRoleRelationDTO) {
    String uuid = queryResourceRoleRelationDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    ResourceRoleExample example = new ResourceRoleExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<ResourceRole> resourceRoleList = dao.selectByExample(example);
    if (resourceRoleList.size() > 0) {
      return resourceRoleList.get(0);
    }
    return null;
  }

  /**
   * 获得所有资源-角色关系
   */
  @Override
  public List<ResourceRole> getResourceRoleRelationList(
      QueryResourceRoleRelationDTO queryResourceRoleRelationDTO) {
    ResourceRoleExample example = new ResourceRoleExample();
    example.setLimit(queryResourceRoleRelationDTO.getPageSize());
    example.setOffset(queryResourceRoleRelationDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return dao.selectByExample(example);
  }

  /**
   * 根据角色uuid获得其对应的资源列表
   */
  @Override
  public List<Resource> getResourceListByRoleUUID(
      QueryResourceRoleRelationDTO queryResourceRoleRelationDTO) {
    String roleUuid = queryResourceRoleRelationDTO.getRoleUuid();
    if (roleUuid == null) {
      return null;
    }
    ResourceRoleExample example = new ResourceRoleExample();
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED)
        .andRoleUuidEqualTo(roleUuid);
    List<String> resourceUuidList = dao.selectByExample(example).stream()
        .map(ResourceRole::getResourceUuid).collect(Collectors.toList());
    List<Resource> result = new ArrayList<>();
    for (String resourceUuid : resourceUuidList) {
      Resource temp = resourceService.getResourceByUUID(new QueryResourceDTO(resourceUuid));
      if (temp != null) {
        result.add(temp);
      }
    }
    return result;
  }

  @Override
  public int addNewResourceRoleRelation(
      InsertResourceRoleRelationDTO insertResourceRoleRelationDTO) {
    Assert.notBlank(insertResourceRoleRelationDTO.getResourceUuid(), "resourceUuid");
    Assert.notBlank(insertResourceRoleRelationDTO.getRoleUuid(), "roleUuid");
    dao.insertSelective(
        new ResourceRole(IdUtil.randomUUID(), insertResourceRoleRelationDTO.getResourceUuid(),
            insertResourceRoleRelationDTO.getRoleUuid()));
    return 1;
  }

  @Override
  public int deleteResourceRoleRelationByUUID(
      QueryResourceRoleRelationDTO queryResourceRoleRelationDTO) {
    String uuid = queryResourceRoleRelationDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    ResourceRole resourceRoleRelation =
        this.getResourceRoleRelationByUUID(queryResourceRoleRelationDTO);

    if (resourceRoleRelation == null) {
      return 2;
    }
    resourceRoleRelation.setDeleted(CommonConstant.DELETED);
    ResourceRoleExample example = new ResourceRoleExample();
    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(resourceRoleRelation, example);
    return 1;
  }

  @Override
  public int modifyResourceRoleRelation(
      ModifyResourceRoleRelationDTO modifyResourceRoleRelationDTO) {
    String uuid = modifyResourceRoleRelationDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    ResourceRole resourceRoleRelation =
        this.getResourceRoleRelationByUUID(modifyResourceRoleRelationDTO);

    if (resourceRoleRelation == null) {
      return 2;
    }
    if (Inspections.isNotBlank(modifyResourceRoleRelationDTO.getResourceUuid())) {
      resourceRoleRelation.setResourceUuid(modifyResourceRoleRelationDTO.getResourceUuid());
    }
    if (Inspections.isNotBlank(modifyResourceRoleRelationDTO.getRoleUuid())) {
      resourceRoleRelation.setRoleUuid(modifyResourceRoleRelationDTO.getRoleUuid());
    }
    ResourceRoleExample example = new ResourceRoleExample();
    example.createCriteria().andUuidEqualTo(uuid);
    dao.updateByExampleSelective(resourceRoleRelation, example);
    return 1;
  }
}
