package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.trip_routine.Insert_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Modify_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Query_Trip_Routine_DTO;
import scut.yulin.trip.service.Trip_Routine_Service;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@RequestMapping("relation")
@RestController
public class Trip_Routine_Controller {
  @Autowired
  Trip_Routine_Service service;

  @GetMapping("trip/routine/list")
  public ResponseVO getRoutineListByTripUUID(@RequestBody Query_Trip_Routine_DTO query_trip_routine_dto,
      @RequestParam("g") Boolean getFullInformation) {
    return ResponseVO.success(service.getRoutineListByTripUUID(query_trip_routine_dto, getFullInformation));
  }

  @PostMapping("trip/routine")
  public ResponseVO addNewTripRoutineRelationAsSerialN(
      @RequestBody Insert_Trip_Routine_DTO insert_trip_routine_dto) {
    int status = service.addNewTripRoutineRelationAsSerialN(insert_trip_routine_dto);
    if (status == 1) {
      return ResponseVO.success("add new trip routine relation ok");
    }
    return ResponseVO.failed("add new trip routine relation failed");
  }

  @DeleteMapping("trip/routine")
  public ResponseVO deleteTripRoutineRelation(@RequestBody Query_Trip_Routine_DTO query_trip_routine_dto) {
    int status = service.deleteTripRoutineRelation(query_trip_routine_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("deleteTripRoutineRelation ok");
      case 2:
        return ResponseVO.success("deleteTripRoutineRelation uuid not found");
      default:
        return ResponseVO.failed("deleteTripRoutineRelation failed");
    }
  }

  @PutMapping("trip/routine")
  public ResponseVO modifyTripRoutineRelation(@RequestBody Modify_Trip_Routine_DTO modify_trip_routine_dto) {
    int status = service.modifyTripRoutineRelation(modify_trip_routine_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("modifyTripRoutineRelation ok");
      case 2:
        return ResponseVO.success("modifyTripRoutineRelation uuid not found");
      default:
        return ResponseVO.failed("modifyTripRoutineRelation failed");
    }
  }

  @PutMapping("trip/up/routine")
  public ResponseVO moveUpOneStep(@RequestBody Modify_Trip_Routine_DTO modify_trip_routine_dto){
    int status = service.moveUpOneStep(modify_trip_routine_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("moveUpOneStep ok");
      case 2:
        return ResponseVO.success("moveUpOneStep uuid not found");
      default:
        return ResponseVO.failed("moveUpOneStep failed");
    }
  }

  @PutMapping("trip/down/routine")
  public ResponseVO moveDownOneStep(@RequestBody Modify_Trip_Routine_DTO modify_trip_routine_dto){
    int status = service.moveDownOneStep(modify_trip_routine_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("moveDownOneStep ok");
      case 2:
        return ResponseVO.success("moveDownOneStep uuid not found");
      default:
        return ResponseVO.failed("moveDownOneStep failed");
    }
  }
}
