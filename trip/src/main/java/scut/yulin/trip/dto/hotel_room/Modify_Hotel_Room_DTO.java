package scut.yulin.trip.dto.hotel_room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modify_Hotel_Room_DTO extends Query_Hotel_Room_DTO{
  String roomUuid;
}
