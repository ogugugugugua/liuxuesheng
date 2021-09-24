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
import scut.yulin.trip.dto.destination.InsertDestinationDTO;
import scut.yulin.trip.dto.destination.ModifyDestinationDTO;
import scut.yulin.trip.dto.destination.QueryDestinationDTO;
import scut.yulin.trip.dto.destination.TransactionalInsertDestinationDTO;
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

  @GetMapping("l/destination/list")
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

  @PostMapping("destination/transactional")
  public ResponseVO addDestinationTransactional(@RequestBody TransactionalInsertDestinationDTO dto) {
    int status = destinationService.addDestinationTransactional(dto);
    if (status == 1) {
      return ResponseVO.success("新增目的地行程成功");
    }
    return ResponseVO.failed("新增目的地行程成功失败");
  }

  @DeleteMapping("destination")
  public ResponseVO deleteDestination(@RequestBody QueryDestinationDTO queryDestinationDTO) {
    int status = destinationService.deleteDestination(queryDestinationDTO);
    if (status == 1) {
      return ResponseVO.success("删除目的地行程成功");
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
