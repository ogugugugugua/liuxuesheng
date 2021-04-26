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
import scut.yulin.trip.dto.hotel.InsertHotelDTO;
import scut.yulin.trip.dto.hotel.ModifyHotelDTO;
import scut.yulin.trip.dto.hotel.QueryHotelDTO;
import scut.yulin.trip.service.HotelService;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("schedule")
public class HotelController {

  @Autowired
  HotelService hotelService;

  @GetMapping("hotel/list")
  public ResponseVO getHotelList(@RequestBody QueryHotelDTO queryHotelDTO) {
    return ResponseVO.success(hotelService.getHotelList(queryHotelDTO));
  }

  @GetMapping("hotel")
  public ResponseVO getHotelByUUID(@RequestBody QueryHotelDTO queryHotelDTO) {
    return ResponseVO.success(hotelService.getHotelByUUID(queryHotelDTO,true));
  }

  @PostMapping("hotel")
  public ResponseVO addNewHotel(@RequestBody InsertHotelDTO insertHotelDTO) {
    int status = hotelService.addHotel(insertHotelDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("add new Hotel ok");
      case 3:
        return ResponseVO.failed("add new Hotel parse error");
      default:
        return ResponseVO.failed("add new Hotel failed");
    }
  }

  @DeleteMapping("hotel")
  public ResponseVO deleteHotel(@RequestBody QueryHotelDTO queryHotelDTO) {
    int status = hotelService.deleteHotel(queryHotelDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("delete Hotel ok");
      case 2:
        return ResponseVO.failed("delete Hotel not found");
      default:
        return ResponseVO.failed("delete Hotel failed");
    }
  }

  @PutMapping("hotel")
  public ResponseVO modifyHotel(@RequestBody ModifyHotelDTO modifyHotelDTO) {
    int status = hotelService.modifyHotel(modifyHotelDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("modify Hotel ok");
      case 2:
        return ResponseVO.failed("modify Hotel not found");
      case 3:
        return ResponseVO.failed("modify Hotel parse error");
      default:
        return ResponseVO.failed("modify Hotel failed");
    }
  }
}
