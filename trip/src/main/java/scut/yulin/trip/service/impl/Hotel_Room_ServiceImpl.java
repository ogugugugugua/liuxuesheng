package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.hotel_room.Insert_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Modify_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Query_Hotel_Room_DTO;
import scut.yulin.trip.dto.hotel_room.Result_Hotel_Room_DTO;
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

  /**
   * 通过某个hotelUUID查找它的所有房间列表
   * @param query_hotel_room_dto
   * @return
   */
  @Override
  public Result_Hotel_Room_DTO getRoomListByHotelUUID(Query_Hotel_Room_DTO query_hotel_room_dto) {
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
      List<Map<String, Room>> list = new ArrayList<>();
      Result_Hotel_Room_DTO result_hotel_room_dto = new Result_Hotel_Room_DTO();
      for (int i = 0; i < relationList.size(); i++) {
        String roomUuid = relationList.get(i).getRoomUuid();
        Room room = roomService.getRoomByUUID(new QueryRoomDTO(roomUuid), true);
        Map<String, Room> map = new HashMap<String, Room>(2);
        map.put(relationList.get(i).getUuid(), room);
        list.add(map);
      }
      result_hotel_room_dto.setHotelRoomRelationUuid_room_list(list);
      result_hotel_room_dto.setHotelUuid(hotelUuid);
      return result_hotel_room_dto;
    }
    return null;
  }

  /**
   * 获得所有的hotel-room关系，通过hotel进行聚合显示
   * @param query_hotel_room_dto
   * @return
   */
  @Override
  public List<Result_Hotel_Room_DTO> getAllRoomList(Query_Hotel_Room_DTO query_hotel_room_dto) {
    HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
    example.setLimit(query_hotel_room_dto.getPageSize());
    example.setOffset(query_hotel_room_dto.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<HoteluuidRoomuuid> relationList = hoteluuidRoomuuidDao.selectByExample(example);
    Set<String> distinctHotelUUIDs = new HashSet<>();
    //找到不重复的酒店   ---    在实现了hotelService之后也可以通过hotelService来获取
    for (HoteluuidRoomuuid relation : relationList) {
      distinctHotelUUIDs.add(relation.getHotelUuid());
    }
    List<Result_Hotel_Room_DTO> result = new ArrayList<>();
    //根据每个酒店找到其拥有的房间，把这些结果拼接到一个list中并返回
    for (String hotelUUID : distinctHotelUUIDs) {
      Result_Hotel_Room_DTO roomListByHotelUUID = this
          .getRoomListByHotelUUID(new Query_Hotel_Room_DTO(null, hotelUUID, null));
      result.add(roomListByHotelUUID);
    }
    return result;
  }

  /**
   * 获取某一行记录，可以用过uuid进行索引，也可以通过hotelUuid+roomUuid进行索引
   *
   * @return 返回结果包含 酒店UUID 和 房间UUID 以及 该行记录的UUID
   */
  @Override
  public HoteluuidRoomuuid getSingleHotelRoomRelationByUUID(
      Query_Hotel_Room_DTO query_hotel_room_dto) {
    String uuid = query_hotel_room_dto.getUuid();
    String roomUuid = query_hotel_room_dto.getRoomUuid();
    String hotelUuid = query_hotel_room_dto.getHotelUuid();

    if (uuid == null && roomUuid == null && hotelUuid == null) {
      return null;
    }

    List<HoteluuidRoomuuid> list = null;

    if (uuid != null) {
      //通过uuid查找
      HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
      example.createCriteria()
          .andUuidEqualTo(uuid)
          .andDeletedEqualTo(CommonConstant.NOT_DELETED);
      list = hoteluuidRoomuuidDao.selectByExample(example);
    } else {
      //通过hotelUuid+roomUuid查找
      HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
      example.createCriteria()
          .andHotelUuidEqualTo(hotelUuid)
          .andRoomUuidEqualTo(roomUuid)
          .andDeletedEqualTo(CommonConstant.NOT_DELETED);
      list = hoteluuidRoomuuidDao.selectByExample(example);
    }

    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  /**
   * 增加hotel-room关系
   * @param insert_hotel_room_dto
   * @return
   */
  @Override
  public int addNewHotelRoomRelation(Insert_Hotel_Room_DTO insert_hotel_room_dto) {
    String hotelUuid = insert_hotel_room_dto.getHotelUuid();
    String roomUuid = insert_hotel_room_dto.getRoomUuid();
    if (hotelUuid == null || roomUuid == null) {
      return 2;
    }
    Assert.notBlank(hotelUuid, "hotel blank");
    Assert.notBlank(roomUuid, "room blank");
    HoteluuidRoomuuid hoteluuidRoomuuid = new HoteluuidRoomuuid(IdUtil.randomUUID(), hotelUuid,
        roomUuid);
    return hoteluuidRoomuuidDao.insertSelective(hoteluuidRoomuuid);
  }

  /**
   * 用于删除hotel-room关系，可以用过uuid进行索引，也可以通过hotelUuid+roomUuid进行索引
   * @param query_hotel_room_dto
   * @return
   */
  @Override
  public int deleteHotelRoomRelationByUUID(Query_Hotel_Room_DTO query_hotel_room_dto) {
    String uuid = query_hotel_room_dto.getUuid();
    String roomUuid = query_hotel_room_dto.getRoomUuid();
    String hotelUuid = query_hotel_room_dto.getHotelUuid();
    if (uuid == null && roomUuid == null && hotelUuid == null) {
      return 2;
    }
    HoteluuidRoomuuid singleHotelRoomRelationByUUID = this
        .getSingleHotelRoomRelationByUUID(query_hotel_room_dto);
    if (singleHotelRoomRelationByUUID == null) {
      return 2;
    }
    singleHotelRoomRelationByUUID.setDeleted(CommonConstant.DELETED);

    HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
    if (uuid != null) {
      example.createCriteria().andUuidEqualTo(uuid);
    } else {
      example.createCriteria().andRoomUuidEqualTo(roomUuid).andHotelUuidEqualTo(hotelUuid);
    }

    hoteluuidRoomuuidDao.updateByExampleSelective(singleHotelRoomRelationByUUID, example);
    return 1;
  }

  /**
   * 用于修改操作，可以找出已被逻辑删除的行
   * @param query_hotel_room_dto
   * @return
   */
  private HoteluuidRoomuuid getSingleHotelRoomRelationByUUIDWithDeleted(
      Query_Hotel_Room_DTO query_hotel_room_dto) {
    String uuid = query_hotel_room_dto.getUuid();
    String roomUuid = query_hotel_room_dto.getRoomUuid();
    String hotelUuid = query_hotel_room_dto.getHotelUuid();

    if (uuid == null && roomUuid == null && hotelUuid == null) {
      return null;
    }

    List<HoteluuidRoomuuid> list = null;

    if (uuid != null) {
      //通过uuid查找
      HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
      example.createCriteria()
          .andUuidEqualTo(uuid);
      list = hoteluuidRoomuuidDao.selectByExample(example);
    } else {
      //通过hotelUuid+roomUuid查找
      HoteluuidRoomuuidExample example = new HoteluuidRoomuuidExample();
      example.createCriteria()
          .andHotelUuidEqualTo(hotelUuid)
          .andRoomUuidEqualTo(roomUuid);
      list = hoteluuidRoomuuidDao.selectByExample(example);
    }

    if (list.size() > 0) {
      return list.get(0);
    }
    return null;
  }

  /**
   * 由UUID来确认修改的行
   * @param modify_hotel_room_dto
   * @return
   */
  @Override
  public int modifyHotelRoomRelation(Modify_Hotel_Room_DTO modify_hotel_room_dto) {
    String uuid = modify_hotel_room_dto.getUuid();
    String roomUuid = modify_hotel_room_dto.getRoomUuid();
    String hotelUuid = modify_hotel_room_dto.getHotelUuid();
    if (uuid == null) {
      return 2;
    }

    HoteluuidRoomuuid singleHotelRoomRelationByUUID = this
        .getSingleHotelRoomRelationByUUIDWithDeleted(modify_hotel_room_dto);
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
