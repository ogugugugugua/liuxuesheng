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
import scut.yulin.trip.dto.transportationType.InsertTransportationTypeDTO;
import scut.yulin.trip.dto.transportationType.ModifyTransportationTypeDTO;
import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.service.TransportationTypeService;

/**
 * 可用交通方式controller
 */
@RestController
@RequestMapping("base")
public class TransportationTypeController {

  @Autowired
  TransportationTypeService transportationTypeService;

  @GetMapping("transportation/type")
  public ResponseVO getTransportationTypeByUUID(
      @RequestBody QueryTransportationTypeDTO queryTransportationTypeDTO) {
    return ResponseVO
        .success(transportationTypeService.getTransportationTypeByUUID(queryTransportationTypeDTO));
  }

  @GetMapping("transportation/type/list")
  public ResponseVO getTransportationTypeList(
      @RequestBody QueryTransportationTypeDTO queryTransportationTypeDTO) {
    return ResponseVO
        .success(transportationTypeService.getTransportationTypeList(queryTransportationTypeDTO));
  }

  @PostMapping("transportation/type")
  public ResponseVO addNewTrasportationType(
      @RequestBody InsertTransportationTypeDTO insertTransportationTypeDTO) {
    if (transportationTypeService.addNewTransportationType(insertTransportationTypeDTO) == 1) {
      return ResponseVO.success("add New Trasportation Type ok");
    }
    return ResponseVO.failed("add New Trasportation Type failed");
  }

  @PutMapping("transportation/type")
  public ResponseVO modifyTrasportationType(
      @RequestBody ModifyTransportationTypeDTO modifyTransportationTypeDTO) {

    int status = transportationTypeService.modifyTrasportationType(modifyTransportationTypeDTO);

    if (status == 1) {
      return ResponseVO.success("modify Trasportation Type ok");
    }
    if (status == 2) {
      return ResponseVO.success("modify Trasportation Type not found");
    }
    return ResponseVO.failed("modify Trasportation Type failed");
  }

  @DeleteMapping("transportation/type")
  public ResponseVO deleteTrasportationType(
      @RequestBody QueryTransportationTypeDTO queryTransportationTypeDTO) {

    int status = transportationTypeService.deleteTrasportationType(queryTransportationTypeDTO);

    if (status == 1) {
      return ResponseVO.success("delete Trasportation Type ok");
    }
    if (status == 2) {
      return ResponseVO.success("delete Trasportation Type not found");
    }
    return ResponseVO.failed("delete Trasportation Type failed");
  }
}
