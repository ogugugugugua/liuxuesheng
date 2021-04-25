package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.hotel_room.Insert_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Modify_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Query_Hotel_Room_DTO;
import scut.yulin.trip.model.HoteluuidRoomuuid;
import scut.yulin.trip.model.Room;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
public interface Hotel_Room_Service {
  public List<Room> getRoomListByHotelUUID(Query_Hotel_Room_DTO query_hotel_room_dto);

  public List<Room> getAllRoomList(Query_Hotel_Room_DTO query_hotel_room_dto);

  public HoteluuidRoomuuid getSingleHotelRoomRelationByUUID(Query_Hotel_Room_DTO query_hotel_room_dto);

  public int addNewHotelRoomRelation(Insert_Hotel_Room_DTO insert_hotel_room_dto);

  public int deleteHotelRoomRelationByUUID(Query_Hotel_Room_DTO query_hotel_room_dto);

  public int modifyHotelRoomRelation(Modify_Hotel_Room_DTO modify_hotel_room_dto);

}
