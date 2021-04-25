package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.equipment.InsertEquipmentDTO;
import scut.yulin.trip.dto.equipment.ModifyEquipmentDTO;
import scut.yulin.trip.dto.equipment.QueryEquipmentDTO;
import scut.yulin.trip.service.EquipmentService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("base")
public class EquipmentController {

  @Autowired
  EquipmentService equipmentService;

  @GetMapping("equipment/list")
  public ResponseVO getEquipmentList(@RequestBody QueryEquipmentDTO queryEquipmentDTO) {
    return ResponseVO.success(equipmentService.getEquipmentList(queryEquipmentDTO));
  }

  @GetMapping("equipment")
  public ResponseVO getEquipmentByUUID(@RequestBody QueryEquipmentDTO queryEquipmentDTO) {
    return ResponseVO.success(equipmentService.getEquipmentByUUID(queryEquipmentDTO));
  }

  @PostMapping("equipment")
  public ResponseVO addNewEquipment(@RequestBody InsertEquipmentDTO insertEquipmentDTO) {
    int status = equipmentService.addNewEquipment(insertEquipmentDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("add new equipment ok");
      default:
        return ResponseVO.failed("add new equipment failed");
    }
  }

  @DeleteMapping("equipment")
  public ResponseVO deleteEquipment(@RequestBody QueryEquipmentDTO queryEquipmentDTO) {
    int status = equipmentService.deleteEquipment(queryEquipmentDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("delete equipment ok");
      case 2:
        return ResponseVO.failed("delete equipment not found");
      default:
        return ResponseVO.failed("delete equipment failed");
    }
  }

  @PutMapping("equipment")
  public ResponseVO modifyEquipment(@RequestBody ModifyEquipmentDTO modifyEquipmentDTO) {
    int status = equipmentService.modifyEquipment(modifyEquipmentDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("modify equipment ok");
      case 2:
        return ResponseVO.failed("modify equipment not found");
      default:
        return ResponseVO.failed("modify equipment failed");
    }
  }
}
