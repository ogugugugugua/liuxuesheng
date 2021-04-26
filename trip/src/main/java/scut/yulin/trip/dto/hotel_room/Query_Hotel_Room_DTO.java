package scut.yulin.trip.dto.hotel_room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import scut.yulin.trip.dto.PageQueryDTO;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Query_Hotel_Room_DTO extends PageQueryDTO {
  String uuid;
  String hotelUuid;
  String roomUuid;
}
