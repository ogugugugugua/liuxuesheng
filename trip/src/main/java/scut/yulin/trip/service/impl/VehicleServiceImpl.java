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
import scut.yulin.trip.dto.comment.QueryCommentDTO;
import scut.yulin.trip.dto.image.QueryImageDTO;
import scut.yulin.trip.dto.price.QueryPriceDTO;
import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.dto.vehicle.InsertVehicleDTO;
import scut.yulin.trip.dto.vehicle.ModifyVehicleDTO;
import scut.yulin.trip.dto.vehicle.QueryVehicleDTO;
import scut.yulin.trip.mbg.mapper.VehicleDao;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.model.Image;
import scut.yulin.trip.model.Price;
import scut.yulin.trip.model.TransportationType;
import scut.yulin.trip.model.Vehicle;
import scut.yulin.trip.model.VehicleExample;
import scut.yulin.trip.service.CommentService;
import scut.yulin.trip.service.ImageService;
import scut.yulin.trip.service.PriceService;
import scut.yulin.trip.service.TransportationTypeService;
import scut.yulin.trip.service.VehicleService;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class VehicleServiceImpl implements VehicleService {

  @Autowired
  VehicleDao vehicleDao;

  @Autowired
  PriceService priceService;

  @Autowired
  TransportationTypeService transportationTypeService;

  @Autowired
  ImageService imageService;

  @Autowired
  CommentService commentService;

  @Override
  public List<Vehicle> getVehicleList(QueryVehicleDTO queryVehicleDTO) {
    VehicleExample example = new VehicleExample();
    example.setLimit(queryVehicleDTO.getPageSize());
    example.setOffset(queryVehicleDTO.getOffset());

    example.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return vehicleDao.selectByExample(example);
  }

  private Vehicle getVehicleByUUIDWithDeleted(QueryVehicleDTO queryVehicleDTO) {
    String scheduleUUID = queryVehicleDTO.getUuid();
    if (scheduleUUID == null) {
      log.debug("UUID not found");
      return null;
    }
    VehicleExample example = new VehicleExample();
    example.createCriteria()
        .andUuidEqualTo(scheduleUUID);

    List<Vehicle> vehicleList = vehicleDao.selectByExample(example);
    if (vehicleList.size() > 0) {
      return vehicleList.get(0);
    }
    return null;
  }

  @Override
  public Vehicle getVehicleByUUID(QueryVehicleDTO queryVehicleDTO, Boolean getFullInformation) {
    String scheduleUUID = queryVehicleDTO.getUuid();
    if (scheduleUUID == null) {
      return null;
    }

    VehicleExample example = new VehicleExample();
    example.createCriteria()
        .andUuidEqualTo(scheduleUUID)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<Vehicle> vehicleList = vehicleDao.selectByExample(example);
    if (vehicleList.size() == 0) {
      return null;
    }

    Vehicle targetVehicle = vehicleList.get(0);

    if (getFullInformation) {
      List<Price> priceList = priceService
          .getPriceListByScheduleUUID(new QueryPriceDTO(null, scheduleUUID, null, null));
      TransportationType transportationType = transportationTypeService
          .getTransportationTypeByUUID(
              new QueryTransportationTypeDTO(targetVehicle.getTransportationTypeUuid()));
      List<Image> imageList = imageService
          .getImageListByScheduleUUID(new QueryImageDTO(null, scheduleUUID, null, null));
      List<Comment> commentList = commentService
          .getCommentListByScheduleUUID(new QueryCommentDTO(null, scheduleUUID, null, null, null));

      targetVehicle.setPriceList(priceList);
      targetVehicle.setTransportationType(transportationType);
      targetVehicle.setImageList(imageList);
      targetVehicle.setCommentList(commentList);
    }

    return targetVehicle;
  }

  private Date getDuration(Date arrivalTime, Date departureTime) {
    try {
      Assert.isTrue(arrivalTime.getTime() > departureTime.getTime(),
          "Wrong relation of departure and arrival");
      SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//如2016-08-10 20:40
      int minutes = (int) ((arrivalTime.getTime() - departureTime.getTime()) / (1000 * 60));
      if (minutes < 0) {
        return null;
      }
      String baseDate = "1970-01-01 08:";
      String durationString = baseDate + minutes;
      return simpleFormat.parse(durationString);
    } catch (ParseException e) {
      return null;
    }
  }

  @Override
  public int addNewVehicle(InsertVehicleDTO insertVehicleDTO) {

    //尝试查询该交通方式类型是否存在
    String transportationTypeUuid = insertVehicleDTO.getTransportationTypeUuid();
    if (transportationTypeUuid == null) {
      return 2;
    }
    QueryTransportationTypeDTO queryTransportationTypeDTO = new QueryTransportationTypeDTO(
        transportationTypeUuid);
    TransportationType transportationType = transportationTypeService
        .getTransportationTypeByUUID(queryTransportationTypeDTO);
    //不存在该交通类型，报错
    if (transportationType == null) {
      log.debug("transportation type 不匹配，新增transportation失败");
      return 2;
    }

    SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//如2016-08-10 20:40

    String aTime = insertVehicleDTO.getArrivalTime();
    String dTime = insertVehicleDTO.getDepartureTime();
    Date arrivalTime;
    Date departureTime;
    Date duration;

    //时间相关的处理
    try {
      departureTime = simpleFormat.parse(dTime);
      arrivalTime = simpleFormat.parse(aTime);
      duration = this.getDuration(arrivalTime, departureTime);
    } catch (ParseException e) {
      log.debug("add vehicle date format error ==> " + e.getMessage());
      return 3;
    }

    String localName = insertVehicleDTO.getLocalName();
    String cnName = Inspections.isNotBlank(insertVehicleDTO.getCnName()) ?
        insertVehicleDTO.getCnName() : "";
    String vehicleSerial =
        Inspections.isNotBlank(insertVehicleDTO.getVehicleSerial()) ? insertVehicleDTO
            .getVehicleSerial() : "";
    String departureLocation =
        Inspections.isNotBlank(insertVehicleDTO.getDepartureLocation()) ? insertVehicleDTO
            .getDepartureLocation() : "";
    String arrivalLocation =
        Inspections.isNotBlank(insertVehicleDTO.getArrivalLocation()) ? insertVehicleDTO
            .getArrivalLocation() : "";
    String grade =
        Inspections.isNotBlank(insertVehicleDTO.getGrade()) ? insertVehicleDTO.getGrade() : "";

    Assert.notNull(arrivalTime, "arrivalTime blank");
    Assert.notNull(duration, "duration blank");
    Assert.notNull(departureTime, "departureTime blank");
    Assert.notBlank(localName, "localName blank");
    Assert.notBlank(transportationTypeUuid, "transportationTypeUuid blank");
    Assert.notBlank(cnName, "cnName blank");

    Vehicle vehicle = new Vehicle(IdUtil.randomUUID(), transportationTypeUuid, localName, cnName,
        vehicleSerial, departureTime, duration, arrivalTime, departureLocation, arrivalLocation,
        grade);

    return vehicleDao.insertSelective(vehicle);
  }

  @Override
  public int deleteVehicle(QueryVehicleDTO queryVehicleDTO) {
    try {
      String uuid = queryVehicleDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Vehicle targetVehicle = this.getVehicleByUUID(queryVehicleDTO, false);
      if (targetVehicle == null) {
        return 2;
      }
      targetVehicle.setDeleted(CommonConstant.DELETED);

      VehicleExample example = new VehicleExample();
      example.createCriteria().andUuidEqualTo(uuid);

      vehicleDao.updateByExampleSelective(targetVehicle, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete vehicle failed" + e.getMessage());
      throw e;
    }
  }

  @Override
  public int modifyVehicle(ModifyVehicleDTO modifyVehicleDTO) {
    try {
      String uuid = modifyVehicleDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Vehicle targetVehicle = this.getVehicleByUUIDWithDeleted(modifyVehicleDTO);
      if (targetVehicle == null) {
        return 2;
      }
      SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");//如2016-08-10 20:40

      String vehicleSerial = modifyVehicleDTO.getVehicleSerial();
      String aTime = modifyVehicleDTO.getArrivalTime();
      String dTime = modifyVehicleDTO.getDepartureTime();
      String localName = modifyVehicleDTO.getLocalName();
      String cnName = modifyVehicleDTO.getCnName();
      String departureLocation = modifyVehicleDTO.getDepartureLocation();
      String arrivalLocation = modifyVehicleDTO.getArrivalLocation();
      String grade = modifyVehicleDTO.getGrade();
      String transportationTypeUuid = modifyVehicleDTO.getTransportationTypeUuid();
      Date arrivalTime;
      Date departureTime;
      Date duration;

      try {
        //如果修改了出发或到达时间，则重新计算duration
        if (Inspections.isNotBlank(aTime) || Inspections.isNotBlank(dTime)) {
          arrivalTime =
              Inspections.isNotBlank(aTime) ? simpleFormat.parse(aTime)
                  : targetVehicle.getArrivalTime();
          departureTime =
              Inspections.isNotBlank(dTime) ? simpleFormat.parse(dTime)
                  : targetVehicle.getDepartureTime();
          duration = this.getDuration(arrivalTime, departureTime);

          targetVehicle.setArrivalTime(arrivalTime);
          targetVehicle.setDepartureTime(departureTime);
          targetVehicle.setDuration(duration);
        }
      } catch (ParseException e) {
        log.debug("modify vehicle parse failed");
        return 3;
      }

      if (Inspections.isNotBlank(transportationTypeUuid)) {
        //如果修改了交通方式类型，则尝试查询该交通方式类型是否存在
        if (transportationTypeService.getTransportationTypeByUUID(
            new QueryTransportationTypeDTO(transportationTypeUuid)) == null) {
          log.debug("transportation type not found");
          return 2;
        }
        targetVehicle.setTransportationTypeUuid(transportationTypeUuid);
      }

      if (Inspections.isNotBlank(vehicleSerial)) {
        targetVehicle.setVehicleSerial(vehicleSerial);
      }
      if (Inspections.isNotBlank(localName)) {
        targetVehicle.setLocalName(localName);
      }
      if (Inspections.isNotBlank(cnName)) {
        targetVehicle.setCnName(cnName);
      }
      if (Inspections.isNotBlank(departureLocation)) {
        targetVehicle.setDepartureLocation(departureLocation);
      }
      if (Inspections.isNotBlank(arrivalLocation)) {
        targetVehicle.setArrivalLocation(arrivalLocation);
      }
      if (Inspections.isNotBlank(grade)) {
        targetVehicle.setGrade(grade);
      }
      targetVehicle.setDeleted(CommonConstant.NOT_DELETED);

      VehicleExample example = new VehicleExample();
      example.createCriteria().andUuidEqualTo(uuid);

      vehicleDao.updateByExampleSelective(targetVehicle, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify vehicle failed");
      return 0;
    }
  }

}
