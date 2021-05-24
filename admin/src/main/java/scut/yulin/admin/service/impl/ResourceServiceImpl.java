package scut.yulin.admin.service.impl;

import cn.hutool.core.util.IdUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.resource.InsertResourceDTO;
import scut.yulin.admin.dto.resource.ModifyResourceDTO;
import scut.yulin.admin.dto.resource.QueryResourceDTO;
import scut.yulin.admin.mbg.mapper.ResourceDao;
import scut.yulin.admin.model.Resource;
import scut.yulin.admin.model.ResourceExample;
import scut.yulin.admin.service.ResourceService;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;

/**
 * @Date 2021/5/23
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class ResourceServiceImpl implements ResourceService {

  @Autowired
  ResourceDao resourceDao;

  @Override
  public Resource getResourceByUUID(QueryResourceDTO queryResourceDTO) {
    String uuid = queryResourceDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    ResourceExample example = new ResourceExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Resource> resourceList = resourceDao.selectByExample(example);
    if (resourceList.size() > 0) {
      return resourceList.get(0);
    }
    return null;
  }

  @Override
  public List<Resource> getResourceList(QueryResourceDTO queryResourceDTO) {
    ResourceExample example = new ResourceExample();
    example.setLimit(queryResourceDTO.getPageSize());
    example.setOffset(queryResourceDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return resourceDao.selectByExample(example);
  }

  @Override
  public int addNewResource(InsertResourceDTO insertResourceDTO) {
    resourceDao.insertSelective(new Resource(IdUtil.randomUUID(),
        insertResourceDTO.getCategoryUuid(),
        insertResourceDTO.getUrl(),
        insertResourceDTO.getName(),
        insertResourceDTO.getDescription(),
        insertResourceDTO.getPath(),
        insertResourceDTO.getComponent(),
        insertResourceDTO.getIconcls(),
        insertResourceDTO.getKeepalive(),
        insertResourceDTO.getRequireauth(),
        insertResourceDTO.getParentid()));
    return 1;
  }

  @Override
  public int deleteResource(QueryResourceDTO queryResourceDTO) {
    try {
      String uuid = queryResourceDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Resource resource = this.getResourceByUUID(queryResourceDTO);
      if (resource == null) {
        return 2;
      }
      resource.setDeleted(CommonConstant.DELETED);

      ResourceExample example = new ResourceExample();
      example.createCriteria().andUuidEqualTo(uuid);
      resourceDao.updateByExampleSelective(resource, example);
      return 1;
    } catch (Exception e) {
      log.debug("deleteResource failed");
      throw e;
    }
  }

  @Override
  public int modifyResource(ModifyResourceDTO modifyResourceDTO) {
    try {
      String uuid = modifyResourceDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Resource resource = this.getResourceByUUID(modifyResourceDTO);
      if (resource == null) {
        return 2;
      }

      if(Inspections.isNotBlank(modifyResourceDTO.getCategoryUuid())){
        resource.setCategoryUuid(modifyResourceDTO.getCategoryUuid());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getUrl())){
        resource.setUrl(modifyResourceDTO.getUrl());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getName())){
        resource.setName(modifyResourceDTO.getName());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getDescription())){
        resource.setDescription(modifyResourceDTO.getDescription());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getPath())){
        resource.setPath(modifyResourceDTO.getPath());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getComponent())){
        resource.setComponent(modifyResourceDTO.getComponent());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getIconcls())){
        resource.setIconcls(modifyResourceDTO.getIconcls());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getKeepalive())){
        resource.setKeepalive(modifyResourceDTO.getKeepalive());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getRequireauth())){
        resource.setRequireauth(modifyResourceDTO.getRequireauth());
      }
      if(Inspections.isNotBlank(modifyResourceDTO.getParentid())){
        resource.setParentid(modifyResourceDTO.getParentid());
      }
      ResourceExample example = new ResourceExample();
      example.createCriteria().andUuidEqualTo(uuid);
      resourceDao.updateByExampleSelective(resource, example);
      return 1;
    } catch (Exception e) {
      log.debug("modifyResource failed");
      throw e;
    }
  }
}
