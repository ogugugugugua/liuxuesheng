package scut.yulin.trip.service.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import scut.yulin.trip.dto.trip.InsertTripDTO;
import scut.yulin.trip.dto.trip.ModifyTripDTO;
import scut.yulin.trip.dto.trip.QueryTripDTO;
import scut.yulin.trip.model.Trip;
import scut.yulin.trip.service.TripService;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class TripServiceImpl implements TripService {

  @Override
  public Trip getRoutineByUUID(QueryTripDTO queryTripDTO) {
    return null;
  }

  @Override
  public List<Trip> getTripList(QueryTripDTO queryTripDTO) {
    return null;
  }

  @Override
  public int addNewTrip(InsertTripDTO insertTripDTO) {
    return 0;
  }

  @Override
  public int deleteTrip(QueryTripDTO queryTripDTO) {
    return 0;
  }

  @Override
  public int modifyTrip(ModifyTripDTO modifyTripDTO) {
    return 0;
  }
}
