package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.hotel.InsertHotelDTO;
import scut.yulin.trip.dto.hotel.ModifyHotelDTO;
import scut.yulin.trip.dto.hotel.QueryHotelDTO;
import scut.yulin.trip.dto.hotel_room.Query_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Result_Hotel_Room_DTO;
import scut.yulin.trip.mbg.mapper.HotelDao;
import scut.yulin.trip.model.Hotel;
import scut.yulin.trip.model.HotelExample;
import scut.yulin.trip.model.Room;
import scut.yulin.trip.model.Schedule;
import scut.yulin.trip.service.HotelService;
import scut.yulin.trip.service.Hotel_Room_Service;
import scut.yulin.trip.service.RoomService;

/**
 * @Date 2021/4/26
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class HotelServiceImpl implements HotelService {

  @Autowired
  HotelDao hotelDao;

  @Autowired
  RoomService roomService;

  @Autowired
  Hotel_Room_Service hotel_room_service;

  @Override
  public List<Hotel> getHotelList(QueryHotelDTO queryHotelDTO) {

    HotelExample example = new HotelExample();
    example.setLimit(queryHotelDTO.getPageSize());
    example.setOffset(queryHotelDTO.getOffset());

    example.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return hotelDao.selectByExample(example);
  }

  @Override
  public Hotel getHotelByUUID(QueryHotelDTO queryHotelDTO, Boolean getFullInformation) {
    System.out.println("service: " + queryHotelDTO.toString());
    String uuid = queryHotelDTO.getUuid();
    if (uuid == null) {
      log.debug("UUID not found");
      return null;
    }
    HotelExample example = new HotelExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<Hotel> hotelList = hotelDao.selectByExample(example);
    if (hotelList.size() == 0) {
      log.debug("hotel with this UUID not found");
      return null;
    }

    Hotel targetHotel = hotelList.get(0);

    if (getFullInformation) {
      //构造一个list用于存储该hotel的所有room
      List<Room> roomList = new ArrayList<>();

      // 找到该hotel的所有room
      Result_Hotel_Room_DTO roomListByHotelUUID = hotel_room_service
          .getRoomListByHotelUUID(new Query_Hotel_Room_DTO(null, targetHotel.getUuid(), null));

      if (roomListByHotelUUID != null) {
        List<Map<String, Room>> hotelRoomRelationUuid_room_list = roomListByHotelUUID
            .getHotelRoomRelationUuid_room_list();
        if (hotelRoomRelationUuid_room_list.size() > 0) {
          // 将这些room从DTO中取出并放到 Hotel.roomList 中
          for (Map<String, Room> roomMap : hotelRoomRelationUuid_room_list) {
            //每一个map都只会包含一条数据，直接在循环中放进Hotel.roomList中
            for (String relationUUID : roomMap.keySet()) {
              roomList.add(roomMap.get(relationUUID));
            }
          }
        }
      }
      //赋值
      targetHotel.setRoomList(roomList);
    }

    return targetHotel;
  }

  @Override
  public int addHotel(InsertHotelDTO insertHotelDTO) {
    String city = insertHotelDTO.getCity();
    String localName = insertHotelDTO.getLocalName();
    Integer stars = insertHotelDTO.getStars();

    Assert.notBlank(city, "city blank");
    Assert.notBlank(localName, "localName blank");
    Assert.notNull(stars, "stars blank");

    String checkInTime = insertHotelDTO.getCheckInTime();
    String checkOutTime = insertHotelDTO.getCheckOutTime();

    String location =
        Inspections.isNotBlank(insertHotelDTO.getLocation()) ? insertHotelDTO.getLocation() : "";
    String countryUuid =
        Inspections.isNotBlank(insertHotelDTO.getCountryUuid()) ? insertHotelDTO.getCountryUuid()
            : "";
    String cnName =
        Inspections.isNotBlank(insertHotelDTO.getCnName()) ? insertHotelDTO.getCnName() : "";
    BigDecimal rating =
        Inspections.isNotEmpty(insertHotelDTO.getRating()) ? insertHotelDTO.getRating()
            : new BigDecimal("5");
    String url = Inspections.isNotBlank(insertHotelDTO.getUrl()) ? insertHotelDTO.getUrl() : "";

    Hotel hotel = new Hotel(IdUtil.randomUUID(), stars, localName, cnName, city, countryUuid,
        location, rating, url, checkInTime, checkOutTime);
    return hotelDao.insertSelective(hotel);
  }

  private Hotel getHotelByUUIDWithDeleted(QueryHotelDTO queryHotelDTO) {
    String uuid = queryHotelDTO.getUuid();
    if (uuid == null) {
      log.debug("UUID not found");
      return null;
    }
    HotelExample example = new HotelExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);

    List<Hotel> hotelList = hotelDao.selectByExample(example);
    if (hotelList.size() == 0) {
      log.debug("hotel with this UUID not found");
      return null;
    }
    return hotelList.get(0);
  }


  @Override
  public int deleteHotel(QueryHotelDTO queryHotelDTO) {
    String uuid = queryHotelDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    Hotel hotel = this.getHotelByUUID(queryHotelDTO, false);
    if (hotel == null) {
      return 2;
    }

    hotel.setDeleted(CommonConstant.DELETED);

    HotelExample example = new HotelExample();
    example.createCriteria().andUuidEqualTo(uuid);

    hotelDao.updateByExampleSelective(hotel, example);
    return 1;
  }

  @Override
  public int modifyHotel(ModifyHotelDTO modifyHotelDTO) {
    String uuid = modifyHotelDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    Hotel targetHotel = this.getHotelByUUIDWithDeleted(modifyHotelDTO);
    if (targetHotel == null) {
      return 2;
    }

    String checkInTime = modifyHotelDTO.getCheckInTime();
    String checkOutTime = modifyHotelDTO.getCheckOutTime();
    String city = modifyHotelDTO.getCity();
    String cnName = modifyHotelDTO.getCnName();
    Integer stars = modifyHotelDTO.getStars();
    String location = modifyHotelDTO.getLocation();
    String countryUuid = modifyHotelDTO.getCountryUuid();
    BigDecimal rating = modifyHotelDTO.getRating();
    String url = modifyHotelDTO.getUrl();

    if (Inspections.isNotBlank(city)) {
      targetHotel.setCity(city);
    }
    if (Inspections.isNotBlank(cnName)) {
      targetHotel.setCnName(cnName);
    }
    if (Inspections.isNotEmpty(stars)) {
      targetHotel.setStars(stars);
    }
    if (Inspections.isNotBlank(location)) {
      targetHotel.setLocation(location);
    }
    if (Inspections.isNotBlank(countryUuid)) {
      targetHotel.setCountryUuid(countryUuid);
    }
    if (Inspections.isNotEmpty(rating)) {
      targetHotel.setRating(rating);
    }
    if (Inspections.isNotBlank(url)) {
      targetHotel.setUrl(url);
    }
    if (Inspections.isNotBlank(checkInTime)) {
      targetHotel.setCheckInTime(checkInTime);
    }
    if (Inspections.isNotBlank(checkOutTime)) {
      targetHotel.setCheckOutTime(checkOutTime);
    }
    targetHotel.setDeleted(CommonConstant.NOT_DELETED);

    HotelExample example = new HotelExample();
    example.createCriteria().andUuidEqualTo(uuid);

    hotelDao.updateByExampleSelective(targetHotel, example);
    return 1;
  }

  @Override
  public Schedule getScheduleByUUID(String uuid, Boolean getFullInformation) {
    if (uuid == null) {
      return null;
    }
    return this.getHotelByUUID(new QueryHotelDTO(uuid), getFullInformation);
  }

}
