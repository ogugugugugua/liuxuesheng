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
import scut.yulin.trip.dto.routine.InsertRoutineDTO;
import scut.yulin.trip.dto.routine.ModifyRoutineDTO;
import scut.yulin.trip.dto.routine.QueryRoutineDTO;
import scut.yulin.trip.service.RoutineService;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("rc")
public class RoutineController {

  @Autowired
  RoutineService routineService;

  @GetMapping("routine")
  public ResponseVO getRoutineByUUID(@RequestBody QueryRoutineDTO queryRoutineDTO,
      @RequestParam("g") Boolean getFullInformation) {
    return ResponseVO.success(routineService.getRoutineByUUID(queryRoutineDTO, getFullInformation));
  }

  @GetMapping("routine/list")
  public ResponseVO getRoutineList(@RequestBody QueryRoutineDTO queryRoutineDTO) {
    return ResponseVO.success(routineService.getRoutineList(queryRoutineDTO));
  }

  @PostMapping("routine")
  public ResponseVO addNewRoutine(@RequestBody InsertRoutineDTO insertRoutineDTO) {
    int status = routineService.addNewRoutine(insertRoutineDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("add new routine ok");
      case 3:
        return ResponseVO.failed("add new routine curDate parse error");
      default:
        return ResponseVO.failed("add new routine failed");
    }
  }

  @DeleteMapping("routine")
  public ResponseVO deleteRoutine(@RequestBody QueryRoutineDTO queryRoutineDTO) {
    int status = routineService.deleteRoutine(queryRoutineDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("delete routine ok");
      case 2:
        return ResponseVO.failed("delete routine not found");
      default:
        return ResponseVO.failed("delete routine failed");
    }
  }

  @PutMapping("routine")
  public ResponseVO modifyRoutine(@RequestBody ModifyRoutineDTO modifyRoutineDTO) {
    int status = routineService.modifyRoutine(modifyRoutineDTO);
    switch (status) {
      case 1:
        return ResponseVO.success("modify routine ok");
      case 3:
        return ResponseVO.failed("modify routine curDate parse error");
      default:
        return ResponseVO.failed("modify routine failed");
    }
  }

  @PutMapping("/schedule/up/one")
  public ResponseVO moveUpOneStep() {
    return ResponseVO.success("行程上移一位成功");
  }

  @PutMapping("/schedule/down/one")
  public ResponseVO moveDownOneStep() {
    return ResponseVO.success("行程下移一位成功");
  }
}
