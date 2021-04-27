package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.hotel.InsertHotelDTO;
import scut.yulin.trip.dto.hotel.ModifyHotelDTO;
import scut.yulin.trip.dto.hotel.QueryHotelDTO;
import scut.yulin.trip.model.Hotel;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
public interface HotelService extends ScheduleService{
  public List<Hotel> getHotelList(QueryHotelDTO queryHotelDTO);

  public Hotel getHotelByUUID(QueryHotelDTO queryHotelDTO, Boolean getFullInformation);

  public int addHotel(InsertHotelDTO insertHotelDTO);

  public int deleteHotel(QueryHotelDTO queryHotelDTO);

  public int modifyHotel(ModifyHotelDTO modifyHotelDTO);

}
