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
import scut.yulin.trip.dto.routine_schedule.Exchange_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Insert_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Modify_Routine_Schedule_DTO;
import scut.yulin.trip.dto.routine_schedule.Query_Routine_Schedule_DTO;
import scut.yulin.trip.service.Routine_Schedule_Service;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("relation")
public class Routine_Schedule_Controller {

  @Autowired
  Routine_Schedule_Service service;

  @GetMapping("routine/schedule/list")
  public ResponseVO getScheduleListByRoutineUUID(@RequestParam("getFullInformation") Boolean getFullInformation,
      @RequestBody Query_Routine_Schedule_DTO query_routine_schedule_dto) {
    return ResponseVO.success(service.getScheduleListByRoutineUUID(query_routine_schedule_dto,getFullInformation));
  }

  @PostMapping("routine/schedule")
  public ResponseVO addNewRoutineScheduleRelation(@RequestBody
      Insert_Routine_Schedule_DTO insert_routine_schedule_dto) {
    int status = service.addNewRoutineScheduleRelation(insert_routine_schedule_dto);
    if (status == 1) {
      return ResponseVO.success("add new routine schedule relation ok");
    }
    return ResponseVO.failed("add new routine schedule relation failed");
  }

  @PutMapping("routine/schedule/exchange")
  public ResponseVO exchangeScheduleSerial(@RequestBody Exchange_Routine_Schedule_DTO exchange) {
    Modify_Routine_Schedule_DTO dto1 = new Modify_Routine_Schedule_DTO();
    Modify_Routine_Schedule_DTO dto2 = new Modify_Routine_Schedule_DTO();
    dto1.setUuid(exchange.getUuid1());
    dto2.setUuid(exchange.getUuid2());
    int status = service.exchangeScheduleSerial(dto1, dto2);
    switch (status) {
      case 1:
        return ResponseVO.success("exchangeScheduleSerial ok");
      case 2:
        return ResponseVO.success("exchangeScheduleSerial uuid not found");
      default:
        return ResponseVO.failed("exchangeScheduleSerial failed");
    }
  }

  @DeleteMapping("routine/schedule")
  public ResponseVO deleteRoutineScheduleRelation(@RequestBody Query_Routine_Schedule_DTO query_routine_schedule_dto) {
    int status = service.deleteRoutineScheduleRelation(query_routine_schedule_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("deleteRoutineScheduleRelation ok");
      case 2:
        return ResponseVO.success("deleteRoutineScheduleRelation uuid not found");
      default:
        return ResponseVO.failed("deleteRoutineScheduleRelation failed");
    }
  }

  @PostMapping("routine/schedule/N")
  public ResponseVO addScheduleAfterSerialN(@RequestBody Insert_Routine_Schedule_DTO dto, @RequestParam("N") Integer N) {
    int status = service.addScheduleAfterSerialN(dto, N);
    switch (status) {
      case 1:
        return ResponseVO.success("addScheduleAfterSerialN ok");
      case 2:
        return ResponseVO.success("addScheduleAfterSerialN uuid not found");
      default:
        return ResponseVO.failed("addScheduleAfterSerialN failed");
    }
  }

  /**
   * 未测试
   * @param modify_routine_schedule_dto
   * @return
   */
  @PutMapping("routine/schedule/modif")
  public ResponseVO modifyRoutineSchedule(@RequestBody Modify_Routine_Schedule_DTO modify_routine_schedule_dto) {
    int status = service.modifyRoutineSchedule(modify_routine_schedule_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("modifyRoutineSchedule ok");
      case 2:
        return ResponseVO.success("modifyRoutineSchedule uuid not found");
      default:
        return ResponseVO.failed("modifyRoutineSchedule failed");
    }
  }
}
