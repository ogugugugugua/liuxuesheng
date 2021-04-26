package scut.yulin.trip.dto.hotel_room;

import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.model.Room;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description 每一个酒店hotel以及它对应的所有房间room
 * 酒店uuid单独保存
 * 每个房间 + 该行记录在表中的uuid 记录在一个map中
 * 这些map记录在一个list中
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result_Hotel_Room_DTO {
  List<Map<String, Room>> hotelRoomRelationUuid_room_list;
  String hotelUuid;
}
