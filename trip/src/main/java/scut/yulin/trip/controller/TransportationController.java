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
import scut.yulin.trip.dto.transportation.InsertTransportationDTO;
import scut.yulin.trip.dto.transportation.ModifyTransportationDTO;
import scut.yulin.trip.dto.transportation.QueryTransportationDTO;
import scut.yulin.trip.service.TransportationService;

/**
 * @Date 2021/4/21
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("base")
public class TransportationController {

  @Autowired
  TransportationService transportationService;

  @GetMapping("transportation")
  public ResponseVO getTransportationByUUID(
      @RequestBody QueryTransportationDTO queryTransportationDTO) {
    return ResponseVO
        .success(transportationService.getTransportationByUUID(queryTransportationDTO));
  }

  @GetMapping("transportation/list")
  public ResponseVO getTransportationList(
      @RequestBody QueryTransportationDTO queryTransportationDTO) {
    return ResponseVO.success(transportationService.getTransportationList(queryTransportationDTO));
  }

  @PostMapping("transportation")
  public ResponseVO addNewTransportation(
      @RequestBody InsertTransportationDTO insertTransportationDTO) {
    if (transportationService.addNewTransportation(insertTransportationDTO) == 1) {
      return ResponseVO.success("addNewTransportation ok");
    }
    return ResponseVO.failed("addNewTransportation failed");
  }

  @DeleteMapping("transportation")
  public ResponseVO deleteTransportation(
      @RequestBody QueryTransportationDTO queryTransportationDTO) {

    int status = transportationService.deleteTransportation(queryTransportationDTO);

    if (status == 1) {
      return ResponseVO.success("deleteTransportation ok");
    }
    if (status == 2) {
      return ResponseVO.failed("deleteTransportation not found");
    }
    return ResponseVO.failed("deleteTransportation failed");
  }

  /**
   * 可用于修改交通方式信息 如果只带有uuid的话，相当于将该条数据从逻辑删除中恢复出来
   */
  @PutMapping("transportation")
  public ResponseVO modifyTransportation(
      @RequestBody ModifyTransportationDTO modifyTransportationDTO) {

    int status = transportationService.modifyTransportation(modifyTransportationDTO);

    if (status == 1) {
      return ResponseVO.success("modifyTransportation ok");
    }
    if (status == 2) {
      return ResponseVO.failed("modifyTransportation not found");
    }
    return ResponseVO.failed("modifyTransportation failed");
  }

  @GetMapping("transportation/correspondingtype")
  public ResponseVO getTranportationTypeByTransportation(
      @RequestBody QueryTransportationDTO queryTransportationDTO) {
    System.out.println("controller ======> "+queryTransportationDTO);
    return ResponseVO.success(transportationService.getTransportationByUUID(queryTransportationDTO)
        .retrieveTransportationType());
  }
}
