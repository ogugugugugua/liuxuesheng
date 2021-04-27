package scut.yulin.trip.service;

import scut.yulin.trip.model.Schedule;

/**
 * @Date 2021/4/27
 * @Author xieyulin
 * @Description TODO
 **/
public interface ScheduleService {
  public Schedule getScheduleByUUID(String uuid, Boolean getFullInformation);
}
