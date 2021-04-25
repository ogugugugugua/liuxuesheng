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
import scut.yulin.trip.dto.vehicle.InsertVehicleDTO;
import scut.yulin.trip.dto.vehicle.ModifyVehicleDTO;
import scut.yulin.trip.dto.vehicle.QueryVehicleDTO;
import scut.yulin.trip.service.VehicleService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("schedule")
public class VehicleController {

  @Autowired
  VehicleService vehicleService;

  @GetMapping("vehicle/list")
  public ResponseVO getVehicleList(@RequestBody QueryVehicleDTO queryVehicleDTO) {
    return ResponseVO.success(vehicleService.getVehicleList(queryVehicleDTO));
  }

  @GetMapping("vehicle")
  public ResponseVO getVehicleByUUID(@RequestBody QueryVehicleDTO queryVehicleDTO) {
    return ResponseVO.success(vehicleService.getVehicleByUUID(queryVehicleDTO,true));
  }

  @PostMapping("vehicle")
  public ResponseVO addNewVehicle(@RequestBody InsertVehicleDTO insertVehicleDTO) {
    int status = vehicleService.addNewVehicle(insertVehicleDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("add new Vehicle ok");
      case 2:
        return ResponseVO.failed("add new vehicle not found");
      case 3:
        return ResponseVO.failed("add new vehicle parse error");
      default:
        return ResponseVO.failed("add new vehicle failed");
    }
  }

  @DeleteMapping("vehicle")
  public ResponseVO deleteVehicle(@RequestBody QueryVehicleDTO queryVehicleDTO) {
    int status = vehicleService.deleteVehicle(queryVehicleDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("delete new Vehicle ok");
      case 2:
        return ResponseVO.failed("delete new vehicle not found");
      default:
        return ResponseVO.failed("delete new vehicle failed");
    }
  }

  @PutMapping("vehicle")
  public ResponseVO modifyVehicle(@RequestBody ModifyVehicleDTO modifyVehicleDTO) {
    int status = vehicleService.modifyVehicle(modifyVehicleDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("modify new Vehicle ok");
      case 2:
        return ResponseVO.failed("modify new vehicle not found");
      case 3:
        return ResponseVO.failed("modify new vehicle parse error");
      default:
        return ResponseVO.failed("modify new vehicle failed");
    }
  }
}
