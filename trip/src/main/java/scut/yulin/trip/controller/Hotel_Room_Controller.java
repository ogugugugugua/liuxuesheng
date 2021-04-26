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
import scut.yulin.trip.dto.hotel_room.Insert_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Modify_Hotel_Room_DTO;
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

  @GetMapping("room/list/by/hotel")
  public ResponseVO getRoomListByHotelUUID(@RequestBody Query_Hotel_Room_DTO query_hotel_room_dto) {
    return ResponseVO.success(service.getRoomListByHotelUUID(query_hotel_room_dto));
  }

  @GetMapping("room/list")
  public ResponseVO getAllRoomList(@RequestBody Query_Hotel_Room_DTO query_hotel_room_dto){
    return ResponseVO.success(service.getAllRoomList(query_hotel_room_dto));
  }

  @PostMapping("room")
  public ResponseVO addNewHotelRoomRelation(@RequestBody Insert_Hotel_Room_DTO insert_hotel_room_dto) {
    int status = service.addNewHotelRoomRelation(insert_hotel_room_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("add new relation ok");
      case 2:
        return ResponseVO.failed("add new relation uuid not found");
      default:
        return ResponseVO.failed("add new relation failed");
    }
  }

  @DeleteMapping("room")
  public ResponseVO deleteHotelRoomRelationByUUID(@RequestBody Query_Hotel_Room_DTO query_hotel_room_dto) {
    int status = service.deleteHotelRoomRelationByUUID(query_hotel_room_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("delete relation ok");
      case 2:
        return ResponseVO.failed("delete relation uuid not found");
      default:
        return ResponseVO.failed("delete relation failed");
    }
  }

  @PutMapping("room")
  public ResponseVO modifyHotelRoomRelation(@RequestBody Modify_Hotel_Room_DTO modify_hotel_room_dto) {
    int status = service.modifyHotelRoomRelation(modify_hotel_room_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("modify relation ok");
      case 2:
        return ResponseVO.failed("modify relation uuid not found");
      default:
        return ResponseVO.failed("modify relation failed");
    }
  }
}
