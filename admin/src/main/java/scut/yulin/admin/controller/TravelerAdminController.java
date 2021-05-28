package scut.yulin.admin.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.admin.dto.login.LoginDTO;
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

  @Value("${jwt.tokenHeader}")
  private String tokenHeader;
  @Value("${jwt.tokenHead}")
  private String tokenHead;
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

  @PostMapping("login")
  public ResponseVO login(@RequestBody LoginDTO dto) {
    System.out.println("login");
    String token = travelerService.login(dto);
    if (token == null) {
      return ResponseVO.failed("用户名或密码错误");
    }
    Map<String, String> tokenMap = new HashMap<>();
    tokenMap.put("token", token);
    tokenMap.put("tokenHead", tokenHead);
    return ResponseVO.success(tokenMap);
  }

}
