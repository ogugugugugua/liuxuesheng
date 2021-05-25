package scut.yulin.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.dto.resource_role.InsertResourceRoleRelationDTO;
import scut.yulin.admin.dto.resource_role.QueryResourceRoleRelationDTO;
import scut.yulin.admin.service.ResourceRoleRelationService;
import scut.yulin.common.vo.ResponseVO;

/**
 * @Date 2021/5/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("resource/role")
public class ResourceRoleController {

  @Autowired
  private ResourceRoleRelationService resourceRoleRelationService;

  @PostMapping("relation")
  public ResponseVO addNewResourceRoleRelation(@RequestBody InsertResourceRoleRelationDTO dto) {
    resourceRoleRelationService.addNewResourceRoleRelation(dto);
    return ResponseVO.success("addNewResourceRoleRelation ok");
  }

  @GetMapping("list")
  public ResponseVO getResourceRoleRelationList(@RequestBody QueryResourceRoleRelationDTO dto) {
    return ResponseVO.success(resourceRoleRelationService.getResourceRoleRelationList(dto));
  }
}
