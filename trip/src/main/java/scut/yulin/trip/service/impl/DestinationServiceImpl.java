package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.math.BigDecimal;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.comment.QueryCommentDTO;
import scut.yulin.trip.dto.destination.InsertDestinationDTO;
import scut.yulin.trip.dto.destination.ModifyDestinationDTO;
import scut.yulin.trip.dto.destination.QueryDestinationDTO;
import scut.yulin.trip.dto.destination.TransactionalInsertDestinationDTO;
import scut.yulin.trip.dto.image.QueryImageDTO;
import scut.yulin.trip.dto.price.QueryPriceDTO;
import scut.yulin.trip.dto.routine_schedule.Insert_Routine_Schedule_DTO;
import scut.yulin.trip.dto.transportation.QueryTransportationDTO;
import scut.yulin.trip.mbg.mapper.DestinationDao;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.model.Destination;
import scut.yulin.trip.model.DestinationExample;
import scut.yulin.trip.model.Image;
import scut.yulin.trip.model.Price;
import scut.yulin.trip.model.Schedule;
import scut.yulin.trip.model.Transportation;
import scut.yulin.trip.service.CommentService;
import scut.yulin.trip.service.DestinationService;
import scut.yulin.trip.service.ImageService;
import scut.yulin.trip.service.PriceService;
import scut.yulin.trip.service.Routine_Schedule_Service;
import scut.yulin.trip.service.TransportationService;

/**
 * @Date 2021/4/23
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class DestinationServiceImpl implements DestinationService {

  @Autowired
  DestinationDao destinationDao;

  @Autowired
  TransportationService transportationService;

  @Autowired
  PriceService priceService;

  @Autowired
  ImageService imageService;

  @Autowired
  CommentService commentService;

  @Autowired
  Routine_Schedule_Service routineService;

  @Override
  public List<Destination> getDestinationList(QueryDestinationDTO queryDestinationDTO) {
    DestinationExample example = new DestinationExample();
    example.setLimit(queryDestinationDTO.getPageSize());
    example.setOffset(queryDestinationDTO.getOffset());

    example.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return destinationDao.selectByExample(example);
  }

  private Destination getDestinationByUUIDWithDeleted(QueryDestinationDTO queryDestinationDTO) {
    String uuid = queryDestinationDTO.getUuid();
    if (uuid == null) {
      log.debug("UUID not found");
      return null;
    }
    DestinationExample example = new DestinationExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);

    List<Destination> destinations = destinationDao.selectByExample(example);
    if (destinations.size() > 0) {
      return destinations.get(0);
    }
    return null;
  }


  @Override
  public Destination getDestinationByUUID(QueryDestinationDTO queryDestinationDTO,
      Boolean getFullInformation) {
    String uuid = queryDestinationDTO.getUuid();
    if (uuid == null) {
      log.debug("UUID not found");
      return null;
    }

    DestinationExample example = new DestinationExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<Destination> destinations = destinationDao.selectByExample(example);
    if (destinations.size() == 0) {
      log.debug("destination with this UUID not found");
      return null;
    }

    Destination targetDestination = destinations.get(0);
    String destinationUuid = targetDestination.getUuid();

    if (getFullInformation) {
      //call corresponding service to get full information
      List<Transportation> transportationList = transportationService
          .getTransportationListByScheduleUUID(new QueryTransportationDTO(null, destinationUuid));
      List<Price> priceList = priceService
          .getPriceListByScheduleUUID(new QueryPriceDTO(null, destinationUuid, null, null));
      List<Image> imageList = imageService
          .getImageListByScheduleUUID(new QueryImageDTO(null, destinationUuid, null, null));
      List<Comment> commentList = commentService
          .getCommentListByScheduleUUID(
              new QueryCommentDTO(null, destinationUuid, null, null, null));

      for (int i = 0; i < transportationList.size(); i++) {
        String transportationUUID = transportationList.get(i).getUuid();
        Transportation transportationWithFullInformation = transportationService
            .getTransportationByUUID(new QueryTransportationDTO(transportationUUID, null));
        transportationList.set(i, transportationWithFullInformation);
      }

      //set
      targetDestination.setCommentList(commentList);
      targetDestination.setImageList(imageList);
      targetDestination.setPriceList(priceList);
      targetDestination.setTransportationList(transportationList);
    }

    return targetDestination;
  }

  @Override
  public int addDestinationTransactional(TransactionalInsertDestinationDTO dto) {
    String description = dto.getDescription();
    String city = dto.getCity();
    String location = dto.getLocation();
    String localName = dto.getLocalName();
    String cnName = Inspections.isNotBlank(dto.getCnName()) ? dto
        .getCnName() : "";
    String countryUuid =
        Inspections.isNotBlank(dto.getCountryUuid()) ? dto
            .getCountryUuid() : "";
    String duration =
        Inspections.isNotBlank(dto.getDuration()) ? dto
            .getDuration() : "";
    BigDecimal rating =
        Inspections.isNotEmpty(dto.getRating()) ? dto.getRating()
            : new BigDecimal("5");
    String url =
        Inspections.isNotBlank(dto.getUrl()) ? dto.getUrl() : "";
    String specialRequirement =
        Inspections.isNotBlank(dto.getSpecialRequirement()) ? dto
            .getSpecialRequirement() : "";

    Assert.notBlank(description, "description not found");
    Assert.notBlank(city, "city not found");
    Assert.notBlank(location, "location not found");
    Assert.notBlank(localName, "localName not found");

    String uuid = IdUtil.randomUUID();

    Destination destination = new Destination(uuid, localName, cnName, city, countryUuid, location,
        rating, duration, url, description, specialRequirement);
    destinationDao.insertSelective(destination);
    routineService.addNewRoutineScheduleRelation(
        new Insert_Routine_Schedule_DTO(dto.getRoutineUuid(), uuid,
            CommonConstant.SCHEDULE_TYPE_DESTINATION, dto.getScheduleSerial()));
    return 1;
  }

  @Override
  public int addDestination(InsertDestinationDTO insertDestinationDTO) {
    String description = insertDestinationDTO.getDescription();
    String city = insertDestinationDTO.getCity();
    String location = insertDestinationDTO.getLocation();
    String localName = insertDestinationDTO.getLocalName();
    String cnName = Inspections.isNotBlank(insertDestinationDTO.getCnName()) ? insertDestinationDTO
        .getCnName() : "";
    String countryUuid =
        Inspections.isNotBlank(insertDestinationDTO.getCountryUuid()) ? insertDestinationDTO
            .getCountryUuid() : "";
    String duration =
        Inspections.isNotBlank(insertDestinationDTO.getDuration()) ? insertDestinationDTO
            .getDuration() : "";
    BigDecimal rating =
        Inspections.isNotEmpty(insertDestinationDTO.getRating()) ? insertDestinationDTO.getRating()
            : new BigDecimal("5");
    String url =
        Inspections.isNotBlank(insertDestinationDTO.getUrl()) ? insertDestinationDTO.getUrl() : "";
    String specialRequirement =
        Inspections.isNotBlank(insertDestinationDTO.getSpecialRequirement()) ? insertDestinationDTO
            .getSpecialRequirement() : "";

    Assert.notBlank(description, "description not found");
    Assert.notBlank(city, "city not found");
    Assert.notBlank(location, "location not found");
    Assert.notBlank(localName, "localName not found");

    Destination destination = new Destination(IdUtil.randomUUID(), localName, cnName, city,
        countryUuid, location,
        rating, duration, url, description, specialRequirement);
    return destinationDao.insertSelective(destination);
  }

  /**
   * @return 1:ok, 2:not found, other:exception
   */
  @Override
  public int deleteDestination(QueryDestinationDTO queryDestinationDTO) {
    try {
      String uuid = queryDestinationDTO.getUuid();

      if (uuid == null) {
        return 2;
      }
      Destination targetDestination = this.getDestinationByUUID(queryDestinationDTO, false);
      if (targetDestination == null) {
        log.debug("deleteDestination not found");
        return 2;
      }
      targetDestination.setDeleted(CommonConstant.DELETED);

      DestinationExample example = new DestinationExample();
      example.createCriteria().andUuidEqualTo(uuid);

      destinationDao.updateByExampleSelective(targetDestination, example);
      return 1;
    } catch (Exception e) {
      log.debug("deleteDestination failed" + e.getMessage());
      throw e;
    }
  }

  @Override
  public int modifyDestination(ModifyDestinationDTO modifyDestinationDTO) {
    try {
      String uuid = modifyDestinationDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Destination targetDestination = this.getDestinationByUUIDWithDeleted(modifyDestinationDTO);
      if (targetDestination == null) {
        return 2;
      }
      String description = modifyDestinationDTO.getDescription();
      String city = modifyDestinationDTO.getCity();
      String location = modifyDestinationDTO.getLocation();
      String localName = modifyDestinationDTO.getLocalName();
      String cnName = modifyDestinationDTO.getCnName();
      String countryUuid = modifyDestinationDTO.getCountryUuid();
      String duration = modifyDestinationDTO.getDuration();
      String url = modifyDestinationDTO.getUrl();
      String specialRequirement = modifyDestinationDTO.getSpecialRequirement();
      BigDecimal rating = modifyDestinationDTO.getRating();

      if (Inspections.isNotBlank(description)) {
        targetDestination.setDescription(description);
      }
      if (Inspections.isNotBlank(city)) {
        targetDestination.setCity(city);
      }
      if (Inspections.isNotBlank(location)) {
        targetDestination.setLocation(location);
      }
      if (Inspections.isNotBlank(localName)) {
        targetDestination.setLocalName(localName);
      }
      if (Inspections.isNotBlank(cnName)) {
        targetDestination.setCnName(cnName);
      }
      if (Inspections.isNotBlank(countryUuid)) {
        targetDestination.setCountryUuid(countryUuid);
      }
      if (Inspections.isNotBlank(duration)) {
        targetDestination.setDuration(duration);
      }
      if (Inspections.isNotBlank(url)) {
        targetDestination.setUrl(url);
      }
      if (Inspections.isNotBlank(specialRequirement)) {
        targetDestination.setSpecialRequirement(specialRequirement);
      }
      if (Inspections.isNotEmpty(rating)) {
        targetDestination.setRating(rating);
      }
      targetDestination.setDeleted(CommonConstant.NOT_DELETED);

      DestinationExample example = new DestinationExample();
      example.createCriteria().andUuidEqualTo(uuid);

      destinationDao.updateByExampleSelective(targetDestination, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify destination failed" + e.getMessage());
      throw e;
    }
  }

  @Override
  public Schedule getScheduleByUUID(String uuid, Boolean getFullInformation) {
    if (uuid == null) {
      return null;
    }
    return this.getDestinationByUUID(new QueryDestinationDTO(uuid), getFullInformation);
  }
}
