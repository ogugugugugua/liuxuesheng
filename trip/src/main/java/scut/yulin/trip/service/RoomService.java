package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.room.InsertRoomDTO;
import scut.yulin.trip.dto.room.ModifyRoomDTO;
import scut.yulin.trip.dto.room.QueryRoomDTO;
import scut.yulin.trip.model.Room;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
public interface RoomService {
  public Room getRoomByUUID(QueryRoomDTO queryRoomDTO, Boolean getFullInformation);

  public List<Room> getRoomList(QueryRoomDTO queryRoomDTO);

  public int addNewRoom(InsertRoomDTO insertRoomDTO);

  public int deleteRoom(QueryRoomDTO queryRoomDTO);

  public int modifyRoom(ModifyRoomDTO modifyRoomDTO);
}
