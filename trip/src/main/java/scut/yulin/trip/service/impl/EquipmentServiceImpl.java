package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.equipment.InsertEquipmentDTO;
import scut.yulin.trip.dto.equipment.ModifyEquipmentDTO;
import scut.yulin.trip.dto.equipment.QueryEquipmentDTO;
import scut.yulin.trip.mbg.mapper.EquipmentDao;
import scut.yulin.trip.model.Equipment;
import scut.yulin.trip.model.EquipmentExample;
import scut.yulin.trip.service.EquipmentService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class EquipmentServiceImpl implements EquipmentService {

  @Autowired
  EquipmentDao equipmentDao;

  @Override
  public Equipment getEquipmentByUUID(QueryEquipmentDTO queryEquipmentDTO) {
    String uuid = queryEquipmentDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    EquipmentExample example = new EquipmentExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Equipment> equipmentList = equipmentDao.selectByExample(example);
    if (equipmentList.size() > 0) {
      return equipmentList.get(0);
    }
    return null;
  }

  @Override
  public List<Equipment> getEquipmentList(QueryEquipmentDTO queryEquipmentDTO) {
    EquipmentExample example = new EquipmentExample();
    example.setLimit(queryEquipmentDTO.getPageSize());
    example.setOffset(queryEquipmentDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return equipmentDao.selectByExample(example);
  }

  @Override
  public List<Equipment> getEquipmentListByRoomUUID(QueryEquipmentDTO queryEquipmentDTO) {
    String roomUuid = queryEquipmentDTO.getRoomUuid();
    if (roomUuid == null) {
      return null;
    }

    EquipmentExample example = new EquipmentExample();
    example.setOffset(queryEquipmentDTO.getOffset());
    example.setLimit(queryEquipmentDTO.getPageSize());
    example.createCriteria()
        .andRoomUuidEqualTo(roomUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return equipmentDao.selectByExample(example);
  }

  @Override
  public int addNewEquipment(InsertEquipmentDTO insertEquipmentDTO) {
    String equipmentName = insertEquipmentDTO.getEquipmentName();
    String roomUuid = insertEquipmentDTO.getRoomUuid();
    String parameter =
        Inspections.isNotBlank(insertEquipmentDTO.getParameter()) ? insertEquipmentDTO
            .getParameter() : "";
    Integer quantity =
        Inspections.isNotEmpty(insertEquipmentDTO.getQuantity()) ? insertEquipmentDTO.getQuantity()
            : 1;

    Assert.notBlank(equipmentName, "equipmentName blank");
    Assert.notBlank(roomUuid, "roomUuid blank");

    Equipment equipment = new Equipment(IdUtil.randomUUID(), equipmentName, parameter, roomUuid,
        quantity);
    return equipmentDao.insertSelective(equipment);
  }

  @Override
  public int deleteEquipment(QueryEquipmentDTO queryEquipmentDTO) {
    try {
      String uuid = queryEquipmentDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Equipment equipment = this.getEquipmentByUUID(queryEquipmentDTO);
      if (equipment == null) {
        return 2;
      }
      equipment.setDeleted(CommonConstant.DELETED);

      EquipmentExample example = new EquipmentExample();
      example.createCriteria().andUuidEqualTo(uuid);
      equipmentDao.updateByExampleSelective(equipment, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete equipment failed");
      throw e;
    }
  }

  private Equipment getEquipmentByUUIDWithDeleted(QueryEquipmentDTO queryEquipmentDTO) {
    String uuid = queryEquipmentDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    EquipmentExample example = new EquipmentExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);

    List<Equipment> equipmentList = equipmentDao.selectByExample(example);
    if (equipmentList.size() > 0) {
      return equipmentList.get(0);
    }
    return null;
  }

  @Override
  public int modifyEquipment(ModifyEquipmentDTO modifyEquipmentDTO) {
    try {
      String uuid = modifyEquipmentDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Equipment targetEquipment = this.getEquipmentByUUIDWithDeleted(modifyEquipmentDTO);
      if (targetEquipment == null) {
        return 2;
      }

      String equipmentName = modifyEquipmentDTO.getEquipmentName();
      Integer quantity = modifyEquipmentDTO.getQuantity();
      String parameter = modifyEquipmentDTO.getParameter();
      String roomUuid = modifyEquipmentDTO.getRoomUuid();

      if (Inspections.isNotEmpty(quantity)) {
        targetEquipment.setQuantity(quantity);
      }
      if (Inspections.isNotBlank(equipmentName)) {
        targetEquipment.setEquipmentName(equipmentName);
      }
      if (Inspections.isNotBlank(parameter)) {
        targetEquipment.setParameter(parameter);
      }
      if (Inspections.isNotBlank(roomUuid)) {
        targetEquipment.setRoomUuid(roomUuid);
      }
      targetEquipment.setDeleted(CommonConstant.NOT_DELETED);

      EquipmentExample example = new EquipmentExample();
      example.createCriteria().andUuidEqualTo(uuid);

      equipmentDao.updateByExampleSelective(targetEquipment, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify equipment failed");
      throw e;
    }
  }
}
