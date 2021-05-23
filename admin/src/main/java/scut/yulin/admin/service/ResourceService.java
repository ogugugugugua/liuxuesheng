package scut.yulin.admin.service;

import java.util.List;
import scut.yulin.admin.dto.resource.InsertResourceDTO;
import scut.yulin.admin.dto.resource.ModifyResourceDTO;
import scut.yulin.admin.dto.resource.QueryResourceDTO;
import scut.yulin.admin.model.Resource;

/**
 * @Date 2021/5/23
 * @Author xieyulin
 * @Description RBAC资源
 **/
public interface ResourceService {
  Resource getResourceByUUID(QueryResourceDTO queryResourceDTO);

  List<Resource> getResourceList(QueryResourceDTO queryResourceDTO);

  int addNewResource(InsertResourceDTO insertResourceDTO);

  int deleteResource(QueryResourceDTO queryResourceDTO);

  int modifyResource(ModifyResourceDTO modifyResourceDTO);
}
