package scut.yulin.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.portal.service.TravelerReadHistoryService;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("history/traveler/trip")
public class TravelerReadHistoryController {

  @Autowired
  private TravelerReadHistoryService service;

}
