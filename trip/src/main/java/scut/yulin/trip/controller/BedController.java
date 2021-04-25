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
import scut.yulin.trip.dto.bed.InsertBedDTO;
import scut.yulin.trip.dto.bed.ModifyBedDTO;
import scut.yulin.trip.dto.bed.QueryBedDTO;
import scut.yulin.trip.service.BedService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("base")
public class BedController {

  @Autowired
  BedService bedService;

  @GetMapping("bed/list")
  public ResponseVO getBedList(@RequestBody QueryBedDTO queryBedDTO) {
    return ResponseVO.success(bedService.getBedList(queryBedDTO));
  }

  @GetMapping("bed")
  public ResponseVO getBedByUUID(@RequestBody QueryBedDTO queryBedDTO) {
    return ResponseVO.success(bedService.getBedByUUID(queryBedDTO));
  }

  @PostMapping("bed")
  public ResponseVO addNewBed(@RequestBody InsertBedDTO insertBedDTO) {
    int status = bedService.addNewBed(insertBedDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("add new bed ok");
      default:
        return ResponseVO.failed("add new bed failed");
    }
  }

  @DeleteMapping("bed")
  public ResponseVO deleteBed(@RequestBody QueryBedDTO queryBedDTO) {
    int status = bedService.deleteBed(queryBedDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("delete bed ok");
      case 2:
        return ResponseVO.failed("delete bed not found");
      default:
        return ResponseVO.failed("delete bed failed");
    }
  }

  @PutMapping("bed")
  public ResponseVO modifyBed(@RequestBody ModifyBedDTO modifyBedDTO) {
    int status = bedService.modifyBed(modifyBedDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("modify bed ok");
      case 2:
        return ResponseVO.failed("modify bed not found");
      default:
        return ResponseVO.failed("modify bed failed");
    }
  }
}
