package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.bed.QueryBedDTO;
import scut.yulin.trip.dto.equipment.QueryEquipmentDTO;
import scut.yulin.trip.dto.room.InsertRoomDTO;
import scut.yulin.trip.dto.room.ModifyRoomDTO;
import scut.yulin.trip.dto.room.QueryRoomDTO;
import scut.yulin.trip.mbg.mapper.RoomDao;
import scut.yulin.trip.model.Bed;
import scut.yulin.trip.model.Equipment;
import scut.yulin.trip.model.Room;
import scut.yulin.trip.model.RoomExample;
import scut.yulin.trip.service.BedService;
import scut.yulin.trip.service.EquipmentService;
import scut.yulin.trip.service.RoomService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class RoomServiceImpl implements RoomService {

  @Autowired
  RoomDao roomDao;

  @Autowired
  BedService bedService;

  @Autowired
  EquipmentService equipmentService;

  @Override
  public Room getRoomByUUID(QueryRoomDTO queryRoomDTO, Boolean getFullInformation) {
    String roomUUID = queryRoomDTO.getUuid();
    if (roomUUID == null) {
      return null;
    }
    RoomExample example = new RoomExample();
    example.createCriteria()
        .andUuidEqualTo(roomUUID)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Room> roomList = roomDao.selectByExample(example);
    if (roomList.size() == 0) {
      return null;
    }

    Room targetRoom = roomList.get(0);
    if (getFullInformation) {
      List<Bed> bedList = bedService
          .getBedListByRoomUUID(new QueryBedDTO(null, roomUUID));
      List<Equipment> equipmentList = equipmentService
          .getEquipmentListByRoomUUID(new QueryEquipmentDTO(null, roomUUID));

      targetRoom.setBedList(bedList);
      targetRoom.setEquipmentList(equipmentList);
    }
    return targetRoom;
  }

  @Override
  public List<Room> getRoomList(QueryRoomDTO queryRoomDTO) {
    RoomExample example = new RoomExample();
    example.setLimit(queryRoomDTO.getPageSize());
    example.setOffset(queryRoomDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return roomDao.selectByExample(example);
  }

  @Override
  public int addNewRoom(InsertRoomDTO insertRoomDTO) {
    String type = insertRoomDTO.getType();
    BigDecimal discountPrice = insertRoomDTO.getDiscountPrice();
    BigDecimal defaultPrice = insertRoomDTO.getDefaultPrice();
    Integer numberPerson = insertRoomDTO.getNumberPerson();
    String vipGrade = insertRoomDTO.getVipGrade();

    Assert.notBlank(type, "type blank");
    Assert.notBlank(vipGrade, "vipgrade blank");
    Assert.notNull(discountPrice, "discountPrice blank");
    Assert.notNull(defaultPrice, "defaultPrice blank");
    Assert.notNull(numberPerson, "numberPerson blank");

    Room room = new Room(IdUtil.randomUUID(), type, vipGrade, numberPerson, defaultPrice,
        discountPrice);
    return roomDao.insertSelective(room);
  }

  @Override
  public int deleteRoom(QueryRoomDTO queryRoomDTO) {
    try {
      String uuid = queryRoomDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Room room = this.getRoomByUUID(queryRoomDTO, false);
      if (room == null) {
        return 2;
      }
      room.setDeleted(CommonConstant.DELETED);
      System.out.println(room);

      RoomExample example = new RoomExample();
      example.createCriteria().andUuidEqualTo(uuid);
      roomDao.updateByExampleSelective(room, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete bed failed");
      throw e;
    }
  }

  private Room getRoomByUUIDWithDeleted(QueryRoomDTO queryRoomDTO) {
    String uuid = queryRoomDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    RoomExample example = new RoomExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);
    List<Room> roomList = roomDao.selectByExample(example);
    if (roomList.size() > 0) {
      return roomList.get(0);
    }
    return null;
  }

  @Override
  public int modifyRoom(ModifyRoomDTO modifyRoomDTO) {
    try {
      String uuid = modifyRoomDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Room targetRoom = this.getRoomByUUIDWithDeleted(modifyRoomDTO);
      if (targetRoom == null) {
        return 2;
      }

      String type = modifyRoomDTO.getType();
      BigDecimal defaultPrice = modifyRoomDTO.getDefaultPrice();
      Integer numberPerson = modifyRoomDTO.getNumberPerson();
      BigDecimal discountPrice = modifyRoomDTO.getDiscountPrice();
      String vipGrade = modifyRoomDTO.getVipGrade();

      if (Inspections.isNotBlank(type)) {
        targetRoom.setType(type);
      }
      if (Inspections.isNotBlank(vipGrade)) {
        targetRoom.setVipGrade(vipGrade);
      }
      if (Inspections.isNotEmpty(defaultPrice)) {
        targetRoom.setDefaultPrice(defaultPrice);
      }
      if (Inspections.isNotEmpty(discountPrice)) {
        targetRoom.setDiscountPrice(discountPrice);
      }
      if (Inspections.isNotEmpty(numberPerson)) {
        targetRoom.setNumberPerson(numberPerson);
      }
      targetRoom.setDeleted(CommonConstant.NOT_DELETED);

      RoomExample example = new RoomExample();
      example.createCriteria().andUuidEqualTo(uuid);
      roomDao.updateByExampleSelective(targetRoom, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify bed failed");
      return 0;
    }
  }
}
