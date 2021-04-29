package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.trip.InsertTripDTO;
import scut.yulin.trip.dto.trip.ModifyTripDTO;
import scut.yulin.trip.dto.trip.QueryTripDTO;
import scut.yulin.trip.dto.trip_routine.Query_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Result_Trip_Routine_DTO;
import scut.yulin.trip.mbg.mapper.TripDao;
import scut.yulin.trip.model.Trip;
import scut.yulin.trip.model.TripExample;
import scut.yulin.trip.service.TripService;
import scut.yulin.trip.service.Trip_Routine_Service;

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

  @Autowired
  Trip_Routine_Service tripRoutineService;

  @Override
  public Trip getTripByUUID(QueryTripDTO queryTripDTO, Boolean getFullInformation) {
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
    Trip trip = tripList.get(0);
    List<Result_Trip_Routine_DTO> routineList = tripRoutineService
        .getRoutineListByTripUUID(new Query_Trip_Routine_DTO(null, trip.getUuid()), getFullInformation);

    trip.setRoutineList(routineList);

    return trip;
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
    String dTime = insertTripDTO.getDepartTime();
    String creatorUuid = insertTripDTO.getCreatorUuid();
    String title = insertTripDTO.getTitle();
    Integer duration = insertTripDTO.getDuration();
    String classification =
        Inspections.isNotBlank(insertTripDTO.getClassification()) ? insertTripDTO
            .getClassification() : "默认分类";
    String description =
        Inspections.isNotBlank(insertTripDTO.getDescription()) ? insertTripDTO.getDescription()
            : "暂无旅途描述";
    String original = "1";
    String privateTrip = "1".equals(insertTripDTO.getPrivateTrip()) ? "1" : "0";
    String rankTop = "1".equals(insertTripDTO.getRankTop()) ? "1" : "0";

    Assert.notNull(dTime, "departTime blank");
    Assert.notNull(creatorUuid, "creatorUuid blank");
    Assert.notNull(title, "title blank");
    Assert.notNull(duration, "duration blank");
    Assert.notNull(classification, "classification blank");

    Date departureTime;
    try {
      SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");//如2016-08-10
      departureTime = simpleFormat.parse(dTime);
    } catch (ParseException e) {
      e.printStackTrace();
      return 3;
    }

    Trip trip = new Trip(IdUtil.randomUUID(), creatorUuid, title, description, classification,
        departureTime,
        duration, rankTop, privateTrip, original);

    return tripDao.insertSelective(trip);
  }

  @Override
  public int deleteTrip(QueryTripDTO queryTripDTO) {
    String uuid = queryTripDTO.getUuid();
    if (uuid == null) {
      return 2;
    }

    TripExample example = new TripExample();
    example.setLimit(1);
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Trip> tripList = tripDao.selectByExample(example);
    if (tripList.size() == 0) {
      return 2;
    }
    Trip trip = tripList.get(0);
    trip.setDeleted(CommonConstant.DELETED);

    example = new TripExample();
    example.createCriteria().andUuidEqualTo(uuid).andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return tripDao.updateByExampleSelective(trip, example);
  }

  @Override
  public int modifyTrip(ModifyTripDTO modifyTripDTO) {
    String uuid = modifyTripDTO.getUuid();
    if (uuid == null) {
      return 2;
    }
    Trip trip = this.getTripByUUIDWithDeleted(modifyTripDTO);
    if (trip == null) {
      return 2;
    }

    String dTime = modifyTripDTO.getDepartTime();
    String title = modifyTripDTO.getTitle();
    Integer duration = modifyTripDTO.getDuration();
    String classification = modifyTripDTO.getClassification();
    String description = modifyTripDTO.getDescription();
    String original = "1".equals(modifyTripDTO.getOriginal()) ? "1" : "0";
    String privateTrip = "1".equals(modifyTripDTO.getPrivateTrip()) ? "1" : "0";
    String rankTop = "1".equals(modifyTripDTO.getRankTop()) ? "1" : "0";

    if (Inspections.isNotBlank(dTime)) {
      Date departureTime;
      try {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");//如2016-08-10
        departureTime = simpleFormat.parse(dTime);
        trip.setDepartTime(departureTime);
      } catch (ParseException e) {
        e.printStackTrace();
        return 3;
      }
    }

    if (Inspections.isNotBlank(title)) {
      trip.setTitle(title);
    }
    if (Inspections.isNotEmpty(duration)) {
      trip.setDuration(duration);
    }
    if (Inspections.isNotBlank(classification)) {
      trip.setClassification(classification);
    }
    if (Inspections.isNotBlank(description)) {
      trip.setDescription(description);
    }
    if (Inspections.isNotBlank(original)) {
      trip.setOriginal(original);
    }
    if (Inspections.isNotBlank(privateTrip)) {
      trip.setPrivateTrip(privateTrip);
    }
    if (Inspections.isNotBlank(rankTop)) {
      trip.setRankTop(rankTop);
    }
    trip.setDeleted(CommonConstant.NOT_DELETED);
    TripExample example = new TripExample();
    example.createCriteria().andUuidEqualTo(uuid);
    return tripDao.updateByExampleSelective(trip, example);
  }

  private Trip getTripByUUIDWithDeleted(QueryTripDTO queryTripDTO) {
    String uuid = queryTripDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    TripExample example = new TripExample();
    example.setLimit(1);
    example.createCriteria()
        .andUuidEqualTo(uuid);
    List<Trip> tripList = tripDao.selectByExample(example);
    if (tripList.size() == 0) {
      return null;
    }
    return tripList.get(0);
  }

}
