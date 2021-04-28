package scut.yulin.trip.service.impl;

import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.trip.dto.trip.InsertTripDTO;
import scut.yulin.trip.dto.trip.ModifyTripDTO;
import scut.yulin.trip.dto.trip.QueryTripDTO;
import scut.yulin.trip.mbg.mapper.TripDao;
import scut.yulin.trip.model.Trip;
import scut.yulin.trip.model.TripExample;
import scut.yulin.trip.service.TripService;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class TripServiceImpl implements TripService {

  @Autowired
  TripDao tripDao;

  @Override
  public Trip getRoutineByUUID(QueryTripDTO queryTripDTO) {
    String uuid = queryTripDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    TripExample example = new TripExample();
    example.setLimit(1);
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Trip> tripList = tripDao.selectByExample(example);
    if (tripList.size() == 0) {
      return null;
    }
    return tripList.get(0);
  }

  @Override
  public List<Trip> getTripList(QueryTripDTO queryTripDTO) {
    TripExample example = new TripExample();
    example.setLimit(queryTripDTO.getPageSize());
    example.setOffset(queryTripDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return tripDao.selectByExample(example);
  }

  @Override
  public int addNewTrip(InsertTripDTO insertTripDTO) {
    Date departTime = insertTripDTO.getDepartTime();
    String creatorUuid = insertTripDTO.getCreatorUuid();
    String title = insertTripDTO.getTitle();
    Integer duration = insertTripDTO.getDuration();
    String classification = insertTripDTO.getClassification();
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
