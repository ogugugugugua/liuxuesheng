package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.hotel_room.Query_Hotel_Room_DTO;
import scut.yulin.trip.service.Hotel_Room_Service;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("relation")
public class Hotel_Room_Controller {

  @Autowired
  Hotel_Room_Service service;

  @GetMapping("room/list")
  public ResponseVO getRoomListByHotelUUID(Query_Hotel_Room_DTO query_hotel_room_dto) {
    return ResponseVO.success(service.getRoomListByHotelUUID(query_hotel_room_dto));
  }

  public ResponseVO getAllRoomList(Query_Hotel_Room_DTO query_hotel_room_dto){
    return null;
  }
}
