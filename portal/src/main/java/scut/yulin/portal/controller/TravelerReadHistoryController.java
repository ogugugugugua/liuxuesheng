package scut.yulin.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.portal.TravelerReadHistory;
import scut.yulin.portal.service.TravelerReadHistoryService;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description 旅客浏览历史controller
 **/
@RestController
@RequestMapping("history/traveler/trip")
public class TravelerReadHistoryController {

  @Autowired
  private TravelerReadHistoryService service;

  @PostMapping("create")
  public ResponseVO addNewTravelerReadHistory(@RequestBody TravelerReadHistory history) {
    int count = service.addNewTravelerReadHistory(history);
    if (count == 1) {
      return ResponseVO.success("addNewTravelerReadHistory ok");
    } else {
      return ResponseVO.success("addNewTravelerReadHistory failed");
    }
  }

  @GetMapping("list")
  public ResponseVO getTravelerReadHistoryList(
      @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
    return ResponseVO.success(service.getTravelerReadHistoryList(pageNum, pageSize));
  }
}
