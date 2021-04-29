package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.trip.InsertTripDTO;
import scut.yulin.trip.dto.trip.ModifyTripDTO;
import scut.yulin.trip.dto.trip.QueryTripDTO;
import scut.yulin.trip.model.Trip;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
public interface TripService {
  public Trip getTripByUUID(QueryTripDTO queryTripDTO, Boolean getFullInformation);

  public List<Trip> getTripList(QueryTripDTO queryTripDTO);

  public int addNewTrip(InsertTripDTO insertTripDTO);

  public int deleteTrip(QueryTripDTO queryTripDTO);

  public int modifyTrip(ModifyTripDTO modifyTripDTO);
}
