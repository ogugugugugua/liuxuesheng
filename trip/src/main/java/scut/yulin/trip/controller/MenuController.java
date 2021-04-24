package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.menu.InsertMenuDTO;
import scut.yulin.trip.dto.menu.ModifyMenuDTO;
import scut.yulin.trip.dto.menu.QueryMenuDTO;
import scut.yulin.trip.service.MenuService;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("base")
public class MenuController {

  @Autowired
  MenuService menuService;

  @GetMapping("menu")
  public ResponseVO getMenuByUUID(@RequestBody QueryMenuDTO queryMenuDTO) {
    return ResponseVO.success(menuService.getMenuByUUID(queryMenuDTO));
  }

  @GetMapping("menu/list")
  public ResponseVO getMenuList(@RequestBody QueryMenuDTO queryMenuDTO) {
    return ResponseVO.success(menuService.getMenuList(queryMenuDTO));
  }

  @PostMapping("menu")
  public ResponseVO addNewMenu(@RequestBody InsertMenuDTO insertMenuDTO) {
    int status = menuService.addNewMenu(insertMenuDTO);
    if (status == 1) {
      return ResponseVO.success("add new Menu ok");
    }
    return ResponseVO.failed("add new Menu failed");
  }

  @DeleteMapping("menu")
  public ResponseVO deleteMenu(@RequestBody QueryMenuDTO queryMenuDTO) {
    int status = menuService.deleteMenu(queryMenuDTO);
    if (status == 1) {
      return ResponseVO.success("delete menu success");
    }
    if (status == 2) {
      return ResponseVO.failed("delete menu not found");
    }
    return ResponseVO.failed("delete menu failed");
  }

  @PutMapping("menu")
  public ResponseVO modifyMenu(@RequestBody ModifyMenuDTO modifyMenuDTO) {
    int status = menuService.modifyMenu(modifyMenuDTO);
    if (status == 1) {
      return ResponseVO.success("modify menu ok");
    }
    if (status == 2) {
      return ResponseVO.failed("modify menu not found");
    }
    return ResponseVO.failed("modify menu failed");
  }
}
