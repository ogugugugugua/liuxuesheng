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
import scut.yulin.trip.dto.room.InsertRoomDTO;
import scut.yulin.trip.dto.room.ModifyRoomDTO;
import scut.yulin.trip.dto.room.QueryRoomDTO;
import scut.yulin.trip.service.RoomService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("base")
public class RoomController {

  @Autowired
  RoomService roomService;

  @GetMapping("room/list")
  public ResponseVO getRoomList(@RequestBody QueryRoomDTO queryRoomDTO) {
    return ResponseVO.success(roomService.getRoomList(queryRoomDTO));
  }

  @GetMapping("room")
  public ResponseVO getRoomByUUID(@RequestBody QueryRoomDTO queryRoomDTO) {
    return ResponseVO.success(roomService.getRoomByUUID(queryRoomDTO, true));
  }

  @PostMapping("room")
  public ResponseVO addNewRoom(@RequestBody InsertRoomDTO insertRoomDTO) {
    int status = roomService.addNewRoom(insertRoomDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("add new room ok");
      default:
        return ResponseVO.failed("add new room failed");
    }
  }

  @DeleteMapping("room")
  public ResponseVO deleteRoom(@RequestBody QueryRoomDTO queryRoomDTO) {
    int status = roomService.deleteRoom(queryRoomDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("delete room ok");
      case 2:
        return ResponseVO.failed("delete room not found");
      default:
        return ResponseVO.failed("delete room failed");
    }
  }

  @PutMapping("room")
  public ResponseVO modifyRoom(@RequestBody ModifyRoomDTO modifyRoomDTO) {
    int status = roomService.modifyRoom(modifyRoomDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("modify room ok");
      case 2:
        return ResponseVO.failed("modify room not found");
      default:
        return ResponseVO.failed("modify room failed");
    }
  }

}
