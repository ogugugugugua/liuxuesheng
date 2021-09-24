package scut.yulin.es.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.es.service.EsDestinationService;

/**
 * @Date 2021/6/20
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
public class TestController1 {

  @Autowired
  EsDestinationService service;

  @RequestMapping("es-service/search")
  public ResponseVO test4() {
    return ResponseVO.success(service.test4());
  }
}
