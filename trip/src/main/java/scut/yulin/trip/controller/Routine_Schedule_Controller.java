package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.routine_schedule.Insert_Routine_Schedule_DTO;
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
  public ResponseVO getScheduleListByRoutineUUID(@RequestBody
      Query_Routine_Schedule_DTO query_routine_schedule_dto) {
    return ResponseVO.success(service.getScheduleListByRoutineUUID(query_routine_schedule_dto,false));
  }

  @PostMapping("routine/schedule")
  public ResponseVO addNewRoutineScheduleRelation(@RequestBody
      Insert_Routine_Schedule_DTO insert_routine_schedule_dto) {
    System.out.println("addNewRoutineScheduleRelation controller ===>>"+insert_routine_schedule_dto.toString());

    int status = service.addNewRoutineScheduleRelation(insert_routine_schedule_dto);
    switch (status) {
      case 1:
        return ResponseVO.success("add new routine schedule relation ok");
      default:
        return ResponseVO.failed("add new routine schedule relation failed");
    }
  }
}
