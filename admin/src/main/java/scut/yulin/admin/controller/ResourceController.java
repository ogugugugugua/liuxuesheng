package scut.yulin.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.dto.resource.InsertResourceDTO;
import scut.yulin.admin.dto.resource.QueryResourceDTO;
import scut.yulin.admin.service.ResourceService;
import scut.yulin.common.vo.ResponseVO;

/**
 * @Date 2021/5/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("resources")
public class ResourceController {

  @Autowired
  private ResourceService resourceService;

  @PostMapping("resource")
  public ResponseVO addNewResource(@RequestBody InsertResourceDTO dto){
    resourceService.addNewResource(dto);
    return ResponseVO.success("addNewResource ok");
  }

  @GetMapping("list")
  public ResponseVO getResourceList(@RequestBody QueryResourceDTO dto) {
    return ResponseVO.success(resourceService.getResourceList(dto));
  }
}
