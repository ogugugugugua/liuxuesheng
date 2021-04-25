package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.equipment.InsertEquipmentDTO;
import scut.yulin.trip.dto.equipment.ModifyEquipmentDTO;
import scut.yulin.trip.dto.equipment.QueryEquipmentDTO;
import scut.yulin.trip.model.Equipment;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
public interface EquipmentService {
  public Equipment getEquipmentByUUID(QueryEquipmentDTO queryEquipmentDTO);

  public List<Equipment> getEquipmentList(QueryEquipmentDTO queryEquipmentDTO);

  public List<Equipment> getEquipmentListByRoomUUID(QueryEquipmentDTO queryEquipmentDTO);

  public int addNewEquipment(InsertEquipmentDTO insertEquipmentDTO);

  public int deleteEquipment(QueryEquipmentDTO queryEquipmentDTO);

  public int modifyEquipment(ModifyEquipmentDTO modifyEquipmentDTO);
}
