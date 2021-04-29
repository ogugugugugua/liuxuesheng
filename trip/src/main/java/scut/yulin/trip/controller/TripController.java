package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.trip.InsertTripDTO;
import scut.yulin.trip.dto.trip.ModifyTripDTO;
import scut.yulin.trip.dto.trip.QueryTripDTO;
import scut.yulin.trip.service.TripService;

/**
 * @Date 2021/4/29
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
public class TripController {

  @Autowired
  TripService tripService;

  @GetMapping("trip")
  public ResponseVO getTripByUUID(@RequestBody QueryTripDTO queryTripDTO,
      @RequestParam("g") Boolean getFullInformation) {
    return ResponseVO.success(tripService.getTripByUUID(queryTripDTO, getFullInformation));
  }

  @GetMapping("trip/list")
  public ResponseVO getTripList(@RequestBody QueryTripDTO queryTripDTO) {
    return ResponseVO.success(tripService.getTripList(queryTripDTO));
  }

  @PostMapping("trip")
  public ResponseVO addNewTrip(@RequestBody InsertTripDTO insertTripDTO) {
    int status = tripService.addNewTrip(insertTripDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("addNewTrip ok");
      case 3:
        return ResponseVO.failed("addNewTrip parse error");
      default:
        return ResponseVO.failed("addNewTrip failed");
    }
  }

  @DeleteMapping("trip")
  public ResponseVO deleteTrip(@RequestBody QueryTripDTO queryTripDTO) {
    int status = tripService.deleteTrip(queryTripDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("deleteTrip ok");
      case 2:
        return ResponseVO.failed("deleteTrip not found");
      default:
        return ResponseVO.failed("deleteTrip failed");
    }
  }

  @PutMapping("trip")
  public ResponseVO modifyTrip(@RequestBody ModifyTripDTO modifyTripDTO) {
    int status = tripService.modifyTrip(modifyTripDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("modifyTrip ok");
      case 2:
        return ResponseVO.failed("modifyTrip not found");
      case 3:
        return ResponseVO.failed("modifyTrip parse error");
      default:
        return ResponseVO.failed("modifyTrip failed");
    }
  }
}
