package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.service.CountryCodeService;

/**
 * @Date 2021/5/3
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
public class CountryCodeController {

  @Autowired
  CountryCodeService service;

  @GetMapping("country/code/list")
  public ResponseVO getCountryCodeList(){
    return ResponseVO.success(service.getCountryCodeList());
  }
}
