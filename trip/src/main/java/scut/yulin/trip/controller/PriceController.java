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
import scut.yulin.trip.dto.price.InsertPriceDTO;
import scut.yulin.trip.dto.price.ModifyPriceDTO;
import scut.yulin.trip.dto.price.QueryPriceDTO;
import scut.yulin.trip.service.PriceService;

/**
 * @Date 2021/4/22
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("base")
public class PriceController {

  @Autowired
  PriceService priceService;

  @GetMapping("price/list")
  public ResponseVO getPriceList(@RequestBody QueryPriceDTO queryPriceDTO){
    return ResponseVO.success(priceService.getPriceList(queryPriceDTO));
  }

  @GetMapping("price")
  public ResponseVO getPriceByUUID(@RequestBody QueryPriceDTO queryPriceDTO){
    return ResponseVO.success(priceService.getPriceByUUID(queryPriceDTO));
  }

  @PostMapping("price")
  public ResponseVO addNewPrice(@RequestBody InsertPriceDTO insertPriceDTO) {
    int status = priceService.addNewPrice(insertPriceDTO);
    if (status == 1) {
      return ResponseVO.success("addNewPrice ok");
    }
    return ResponseVO.failed("addNewPrice failed");
  }

  @DeleteMapping("price")
  public ResponseVO deletePrice(@RequestBody QueryPriceDTO queryPriceDTO){
    int status = priceService.deletePrice(queryPriceDTO);
    if (status == 1) {
      return ResponseVO.success("deletePrice ok");
    }
    if (status == 2) {
      return ResponseVO.failed("deletePrice not found");
    }
    return ResponseVO.failed("deletePrice failed");
  }

  @PutMapping("price")
  public ResponseVO modifyPrice(@RequestBody ModifyPriceDTO modifyPriceDTO) {
    int status = priceService.modifyPrice(modifyPriceDTO);
    if (status == 1) {
      return ResponseVO.success("modifyPrice ok");
    }
    if (status == 2) {
      return ResponseVO.failed("modifyPrice not found");
    }
    return ResponseVO.failed("modifyPrice failed");
  }
}
