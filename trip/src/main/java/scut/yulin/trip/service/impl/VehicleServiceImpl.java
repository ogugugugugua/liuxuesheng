package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
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

  @Override
  public int addVehicle(InsertVehicleDTO insertVehicleDTO) {
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

    Date arrivalTime = insertVehicleDTO.getArrivalTime();
    Date duration = insertVehicleDTO.getDuration();
    Date departureTime = insertVehicleDTO.getDepartureTime();
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

    Assert.notNull(arrivalTime,"arrivalTime blank");
    Assert.notNull(duration,"duration blank");
    Assert.notNull(departureTime,"departureTime blank");
    Assert.notBlank(localName,"localName blank");
    Assert.notBlank(transportationTypeUuid,"transportationTypeUuid blank");
    Assert.notBlank(cnName,"cnName blank");


    return 0;
  }

  @Override
  public int deleteVehicle(QueryVehicleDTO queryVehicleDTO) {
    return 0;
  }

  @Override
  public int modifyVehicle(ModifyVehicleDTO modifyVehicleDTO) {
    return 0;
  }
}
