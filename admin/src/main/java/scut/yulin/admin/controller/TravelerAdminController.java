package scut.yulin.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.dto.traveler.InsertTravelerDTO;
import scut.yulin.admin.dto.traveler.QueryTravelerDTO;
import scut.yulin.admin.service.TravelerAdminService;
import scut.yulin.common.vo.ResponseVO;

/**
 * @Date 2021/5/28
 * @Author xieyulin
 * @Description 旅客controller
 **/
@RestController
@RequestMapping("travelers")
public class TravelerAdminController {

  @Autowired
  private TravelerAdminService travelerService;

  @GetMapping("list")
  public ResponseVO getTravelerList(@RequestBody QueryTravelerDTO dto) {
    return ResponseVO.success(travelerService.getTravelerList(dto));
  }

  @PostMapping("register")
  public ResponseVO register(@RequestBody InsertTravelerDTO dto) {
    int status = travelerService.addNewTraveler(dto);
    if (status == 1) {
      return ResponseVO.success("addNewTraveler ok");
    }
    return ResponseVO.failed("addNewTraveler failed");
  }

}
