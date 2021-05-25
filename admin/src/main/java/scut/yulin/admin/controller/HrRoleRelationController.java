package scut.yulin.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.dto.hr_role.InsertHrRoleRelationDTO;
import scut.yulin.admin.dto.hr_role.QueryHrRoleRelationDTO;
import scut.yulin.admin.service.HrRoleRelationService;
import scut.yulin.common.vo.ResponseVO;

/**
 * @Date 2021/5/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("hr/role")
public class HrRoleRelationController {

  @Autowired
  private HrRoleRelationService service;

  @PostMapping("relation")
  public ResponseVO addNewHrRoleRelation(@RequestBody InsertHrRoleRelationDTO dto) {
    service.addNewHrRoleRelation(dto);
    return ResponseVO.success("addNewHrRoleRelation ok");
  }

  @GetMapping("list")
  public ResponseVO getHrRoleRelationList(@RequestBody QueryHrRoleRelationDTO dto) {
    return ResponseVO.success(service.getHrRoleRelationList(dto));
  }

  /**
   * TODO: 批量增加某个用户的角色列表
   */

}
