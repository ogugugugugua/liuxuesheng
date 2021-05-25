package scut.yulin.admin.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.dto.role.InsertRoleDTO;
import scut.yulin.admin.dto.role.QueryRoleDTO;
import scut.yulin.admin.service.RoleService;
import scut.yulin.common.vo.ResponseVO;

/**
 * @Date 2021/5/24
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("roles")
@Api(tags = "RoleController", value = "角色controller")
public class RoleController {

  @Autowired
  private RoleService roleService;

  @PostMapping("role")
  public ResponseVO addNewRole(@RequestBody InsertRoleDTO insertRoleDTO) {
    roleService.addNewRole(insertRoleDTO);
    return ResponseVO.success("add new Role ok");
  }

  @GetMapping("list")
  public ResponseVO getRoleList() {
    return ResponseVO.success(roleService.getRoleList(new QueryRoleDTO(null)));
  }
}
