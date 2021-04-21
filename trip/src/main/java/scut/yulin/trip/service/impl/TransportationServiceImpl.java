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
import scut.yulin.trip.dto.transportation.InsertTransportationDTO;
import scut.yulin.trip.dto.transportation.ModifyTransportationDTO;
import scut.yulin.trip.dto.transportation.QueryTransportationDTO;
import scut.yulin.trip.mbg.mapper.TransportationDao;
import scut.yulin.trip.model.Transportation;
import scut.yulin.trip.model.TransportationExample;
import scut.yulin.trip.service.TransportationService;

/**
 * @Date 2021/4/21
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class TransportationServiceImpl implements TransportationService {

  @Autowired
  TransportationDao transportationDao;

  /**
   * 根据UUID获取可用交通方式，不包含已被逻辑删除项
   * @param queryTransportationDTO
   * @return
   */
  @Override
  public Transportation getTransportationByUUID(QueryTransportationDTO queryTransportationDTO) {
    TransportationExample example = new TransportationExample();
    String uuid = queryTransportationDTO.getUuid();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Transportation> transportationList = transportationDao.selectByExample(example);
    if (transportationList.size() > 0) {
      return transportationList.get(0);
    }
    return null;
  }

  /**
   * 类内方法，不向外暴露
   * 根据UUID获取可用交通方式，包含已被逻辑删除项
   * @param queryTransportationDTO
   * @return
   */
  public Transportation getTransportationByUUIDWithDeleted(
      ModifyTransportationDTO queryTransportationDTO) {
    TransportationExample example = new TransportationExample();
    String uuid = queryTransportationDTO.getUuid();
    example.createCriteria()
        .andUuidEqualTo(uuid);
    List<Transportation> transportationList = transportationDao.selectByExample(example);
    if (transportationList.size() > 0) {
      return transportationList.get(0);
    }
    return null;
  }

  /**
   * 查询所有可用交通方式。不包含已被逻辑删除项
   * @param queryTransportationDTO
   * @return 可用交通方式列表
   */
  @Override
  public List<Transportation> getTransportationList(QueryTransportationDTO queryTransportationDTO) {
    TransportationExample example = new TransportationExample();
    example.setLimit(queryTransportationDTO.getPageSize());
    example.setOffset(queryTransportationDTO.getOffset());

    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return transportationDao.selectByExample(example);
  }

  /**
   * 新增可用交通方式
   * @param insertTransportationDTO
   * @return 新增结果
   */
  @Override
  public int addNewTransportation(InsertTransportationDTO insertTransportationDTO) {
    String vehicleNumber = insertTransportationDTO.getVehicleNumber();
    String transportationTypeUuid = insertTransportationDTO.getTransportationTypeUuid();
    String creatorUuid = insertTransportationDTO.getCreatorUuid();
    String scheduleUuid = insertTransportationDTO.getScheduleUuid();
    String scheduleTypeUuid = insertTransportationDTO.getScheduleTypeUuid();
    BigDecimal defaultPrice =
        Inspections.isNotEmpty(insertTransportationDTO.getDefaultPrice()) ? insertTransportationDTO
            .getDefaultPrice() : new BigDecimal("-1");
    String boardingLocation = Inspections.isNotBlank(insertTransportationDTO.getBoardingLocation())
        ? insertTransportationDTO.getBoardingLocation() : "No available boarding location";

    Assert.notBlank(vehicleNumber);
    Assert.notBlank(transportationTypeUuid);
    Assert.notBlank(creatorUuid);
    Assert.notBlank(scheduleUuid);
    Assert.notBlank(scheduleTypeUuid);
    Assert.notNull(defaultPrice);
    Assert.notBlank(boardingLocation);

    Transportation transportation = new Transportation(IdUtil.randomUUID(),
        scheduleUuid, scheduleTypeUuid, transportationTypeUuid, vehicleNumber, boardingLocation,
        creatorUuid, defaultPrice);

    return transportationDao.insertSelective(transportation);
  }

  /**
   * 根据uuid逻辑删除该可用交通方式
   *
   * @return 1:ok, 2:not found, 0:exception
   */
  @Override
  public int deleteTransportation(QueryTransportationDTO queryTransportationDTO) {
    try {
      Transportation targetTransportation = this.getTransportationByUUID(queryTransportationDTO);
      if (targetTransportation == null) {
        log.debug("deleteTrasportation not found");
        return 2;
      }

      targetTransportation.setDeleted(CommonConstant.DELETED);

      TransportationExample example = new TransportationExample();
      example.createCriteria().andUuidEqualTo(queryTransportationDTO.getUuid());

      transportationDao.updateByExampleSelective(targetTransportation, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete transportation exception ===> " + e);
      return 0;
    }
  }

  /**
   * 根据uuid索引并修改该可用交通方式属性
   * @return 1:ok, 2:not found, 0:exception
   */
  @Override
  public int modifyTransportation(ModifyTransportationDTO modifyTransportationDTO) {
    try {
      Transportation targetTransportation = this
          .getTransportationByUUIDWithDeleted(modifyTransportationDTO);
      if (targetTransportation == null) {
        return 2;
      }

      String transportationTypeUuid = modifyTransportationDTO.getTransportationTypeUuid();
      BigDecimal defaultPrice = modifyTransportationDTO.getDefaultPrice();
      String boardingLocation = modifyTransportationDTO.getBoardingLocation();
      String vehicleNumber = modifyTransportationDTO.getVehicleNumber();
      String scheduleUuid = modifyTransportationDTO.getScheduleUuid();
      String scheduleTypeUuid = modifyTransportationDTO.getScheduleTypeUuid();

      if (Inspections.isNotBlank(transportationTypeUuid)) {
        targetTransportation.setTransportationTypeUuid(transportationTypeUuid);
      }
      if (Inspections.isNotBlank(boardingLocation)) {
        targetTransportation.setBoardingLocation(boardingLocation);
      }
      if (Inspections.isNotBlank(vehicleNumber)) {
        targetTransportation.setVehicleNumber(vehicleNumber);
      }
      if (Inspections.isNotBlank(scheduleTypeUuid)) {
        targetTransportation.setScheduleTypeUuid(scheduleTypeUuid);
      }
      if (Inspections.isNotBlank(scheduleUuid)) {
        targetTransportation.setScheduleUuid(scheduleUuid);
      }
      if (defaultPrice != null) {
        targetTransportation.setDefaultPrice(defaultPrice);
      }
      targetTransportation.setDeleted(CommonConstant.NOT_DELETED);

      TransportationExample example = new TransportationExample();
      example.createCriteria().andUuidEqualTo(modifyTransportationDTO.getUuid());

      transportationDao.updateByExampleSelective(targetTransportation, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify exception ===> " + e);
      return 0;
    }

  }
}
