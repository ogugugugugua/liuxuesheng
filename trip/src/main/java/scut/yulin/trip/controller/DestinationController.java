package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.destination.InsertDestinationDTO;
import scut.yulin.trip.dto.destination.ModifyDestinationDTO;
import scut.yulin.trip.dto.destination.QueryDestinationDTO;
import scut.yulin.trip.service.DestinationService;

/**
 * @Date 2021/4/23
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("schedule")
public class DestinationController {

  @Autowired
  DestinationService destinationService;

  @PostMapping("destination/uuid")
  public ResponseVO getDestinationByUUID(@RequestBody QueryDestinationDTO queryDestinationDTO) {
    return ResponseVO.success(destinationService.getDestinationByUUID(queryDestinationDTO, true));
  }

  @PostMapping("l/destination/list")
  public ResponseVO getDestinationList(@RequestBody QueryDestinationDTO queryDestinationDTO) {
    return ResponseVO.success(destinationService.getDestinationList(queryDestinationDTO));
  }

  @PostMapping("destination")
  public ResponseVO addDestination(@RequestBody InsertDestinationDTO insertDestinationDTO) {
    System.out.println(insertDestinationDTO.toString());
    int status = destinationService.addDestination(insertDestinationDTO);
    if (status == 1) {
      return ResponseVO.success("add new destination ok");
    }
    return ResponseVO.failed("add new destination failed");
  }

  @DeleteMapping("destination")
  public ResponseVO deleteDestination(@RequestBody QueryDestinationDTO queryDestinationDTO) {
    int status = destinationService.deleteDestination(queryDestinationDTO);
    if (status == 1) {
      return ResponseVO.success("delete destination ok");
    }
    if (status == 2) {
      return ResponseVO.failed("delete destination not found");
    }
    return ResponseVO.failed("delete destination failed");
  }

  @PutMapping("destination")
  public ResponseVO modifyDestination(@RequestBody ModifyDestinationDTO modifyDestinationDTO) {
    int status = destinationService.modifyDestination(modifyDestinationDTO);
    if (status == 1) {
      return ResponseVO.success("modify destination ok");
    }
    if (status == 2) {
      return ResponseVO.failed("modify destination not found");
    }
    return ResponseVO.failed("modify destination failed");
  }
}
