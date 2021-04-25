package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.hotel_room.Insert_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Modify_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Query_Hotel_Room_DTO;
import scut.yulin.trip.dto.room.QueryRoomDTO;
import scut.yulin.trip.mbg.mapper.HoteluuidRoomuuidDao;
import scut.yulin.trip.model.HoteluuidRoomuuid;
import scut.yulin.trip.model.HoteluuidRoomuuidExample;
import scut.yulin.trip.model.Room;
import scut.yulin.trip.service.Hotel_Room_Service;
import scut.yulin.trip.service.RoomService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class Hotel_Room_ServiceImpl implements Hotel_Room_Service {

  @Autowired
  HoteluuidRoomuuidDao hoteluuidRoomuuidDao;

  @Autowired
  RoomService roomService;

  @Override
  public List<Room> getRoomListByHotelUUID(Query_Hotel_Room_DTO query_hotel_room_dto) {
    String hotelUuid = query_hotel_room_dto.getHotelUuid();
    if (hotelUuid == null) {
      return null;
    }

    HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
    example.setLimit(query_hotel_room_dto.getPageSize());
    example.setOffset(query_hotel_room_dto.getOffset());
    example.createCriteria()
        .andHotelUuidEqualTo(hotelUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<HoteluuidRoomuuid> relationList = hoteluuidRoomuuidDao.selectByExample(example);

    if (relationList.size() > 0) {
      List<Room> result = new ArrayList<>();
      for (int i = 0; i < relationList.size(); i++) {
        String roomUuid = relationList.get(i).getRoomUuid();
        result.add(roomService.getRoomByUUID(new QueryRoomDTO(roomUuid), true));
      }
      return result;
    }
    return null;
  }

  @Override
  public List<Room> getAllRoomList(Query_Hotel_Room_DTO query_hotel_room_dto) {
    HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
    example.setLimit(query_hotel_room_dto.getPageSize());
    example.setOffset(query_hotel_room_dto.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<HoteluuidRoomuuid> relationList = hoteluuidRoomuuidDao.selectByExample(example);

    if (relationList.size() > 0) {
      List<Room> result = new ArrayList<>();
      for (int i = 0; i < relationList.size(); i++) {
        String roomUuid = relationList.get(i).getRoomUuid();
        result.add(roomService.getRoomByUUID(new QueryRoomDTO(roomUuid), true));
      }
      return result;
    }
    return null;
  }

  @Override
  public HoteluuidRoomuuid getSingleHotelRoomRelationByUUID(
      Query_Hotel_Room_DTO query_hotel_room_dto) {
    String uuid = query_hotel_room_dto.getUuid();
    if (uuid == null) {
      return null;
    }
    HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<HoteluuidRoomuuid> list = hoteluuidRoomuuidDao.selectByExample(example);

    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  @Override
  public int addNewHotelRoomRelation(Insert_Hotel_Room_DTO insert_hotel_room_dto) {
    String hotelUuid = insert_hotel_room_dto.getHotelUuid();
    String roomUuid = insert_hotel_room_dto.getRoomUuid();
    Assert.notBlank(hotelUuid, "hotel blank");
    Assert.notBlank(roomUuid, "room blank");
    HoteluuidRoomuuid hoteluuidRoomuuid = new HoteluuidRoomuuid(IdUtil.randomUUID(), hotelUuid,
        roomUuid);
    return hoteluuidRoomuuidDao.insertSelective(hoteluuidRoomuuid);
  }

  @Override
  public int deleteHotelRoomRelationByUUID(Query_Hotel_Room_DTO query_hotel_room_dto) {
    String uuid = query_hotel_room_dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    HoteluuidRoomuuid singleHotelRoomRelationByUUID = this
        .getSingleHotelRoomRelationByUUID(query_hotel_room_dto);
    if (singleHotelRoomRelationByUUID == null) {
      return 2;
    }
    singleHotelRoomRelationByUUID.setDeleted(CommonConstant.DELETED);

    HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
    example.createCriteria().andUuidEqualTo(uuid);

    hoteluuidRoomuuidDao.updateByExampleSelective(singleHotelRoomRelationByUUID, example);
    return 1;
  }

  @Override
  public int modifyHotelRoomRelation(Modify_Hotel_Room_DTO modify_hotel_room_dto) {
    String uuid = modify_hotel_room_dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    String hotelUuid = modify_hotel_room_dto.getHotelUuid();
    String roomUuid = modify_hotel_room_dto.getRoomUuid();

    HoteluuidRoomuuid singleHotelRoomRelationByUUID = this
        .getSingleHotelRoomRelationByUUID(modify_hotel_room_dto);
    if (singleHotelRoomRelationByUUID == null) {
      return 2;
    }

    if (Inspections.isNotBlank(hotelUuid)) {
      singleHotelRoomRelationByUUID.setHotelUuid(hotelUuid);
    }
    if (Inspections.isNotBlank(roomUuid)) {
      singleHotelRoomRelationByUUID.setRoomUuid(roomUuid);
    }
    singleHotelRoomRelationByUUID.setDeleted(CommonConstant.NOT_DELETED);

    HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
    example.createCriteria().andUuidEqualTo(uuid);

    hoteluuidRoomuuidDao.updateByExampleSelective(singleHotelRoomRelationByUUID, example);
    return 1;
  }
}
