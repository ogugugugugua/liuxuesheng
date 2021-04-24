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
import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.mbg.mapper.TransportationDao;
import scut.yulin.trip.model.Transportation;
import scut.yulin.trip.model.TransportationExample;
import scut.yulin.trip.model.TransportationType;
import scut.yulin.trip.service.TransportationService;
import scut.yulin.trip.service.TransportationTypeService;

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

  @Autowired
  TransportationTypeService transportationTypeService;

  /**
   * 根据UUID获取可用交通方式，不包含已被逻辑删除项
   */
  @Override
  public Transportation getTransportationByUUID(QueryTransportationDTO queryTransportationDTO) {
    String uuid = queryTransportationDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    TransportationExample example = new TransportationExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Transportation> transportationList = transportationDao.selectByExample(example);
    //存在这个可用交通方式
    if (transportationList.size() > 0) {
      Transportation transportation = transportationList.get(0);

      //尝试查询该交通方式类型
      QueryTransportationTypeDTO queryTransportationTypeDTO = new QueryTransportationTypeDTO(
          transportation.getTransportationTypeUuid());
      TransportationType transportationType = transportationTypeService
          .getTransportationTypeByUUID(queryTransportationTypeDTO);

      //不存在该交通类型，报错
      if (transportationType == null) {
        log.debug("transportation not found due to conflicts of transportation type");
        return null;
      }

      //设置其交通类型并返回查询结果
      transportation.setTransportationType(transportationType);
      return transportation;
    }
    return null;
  }

  /**
   * 类内方法，不向外暴露 根据UUID获取可用交通方式，包含已被逻辑删除项
   */
  private Transportation getTransportationByUUIDWithDeleted(
      ModifyTransportationDTO queryTransportationDTO) {
    String uuid = queryTransportationDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    TransportationExample example = new TransportationExample();
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
   *
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
   * 查询某个schedule的所有可用交通方式。不包含已被逻辑删除项
   *
   * @return 可用交通方式列表
   */
  @Override
  public List<Transportation> getTransportationListByScheduleUUID(
      QueryTransportationDTO queryTransportationDTO) {
    String scheduleUUID = queryTransportationDTO.getScheduleUuid();
    if (scheduleUUID == null) {
      return null;
    }
    TransportationExample example = new TransportationExample();
    example.setLimit(queryTransportationDTO.getPageSize());
    example.setOffset(queryTransportationDTO.getOffset());

    example.createCriteria()
        .andScheduleUuidEqualTo(scheduleUUID)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return transportationDao.selectByExample(example);
  }

  /**
   * 新增可用交通方式
   *
   * @return 新增结果 -1:不存在所选择的可用交通类型，需要新建对应交通类型； 1:OK
   */
  @Override
  public int addNewTransportation(InsertTransportationDTO insertTransportationDTO) {
    String transportationTypeUuid = insertTransportationDTO.getTransportationTypeUuid();

    //尝试查询该交通方式类型是否存在
    QueryTransportationTypeDTO queryTransportationTypeDTO = new QueryTransportationTypeDTO(
        transportationTypeUuid);
    TransportationType transportationType = transportationTypeService
        .getTransportationTypeByUUID(queryTransportationTypeDTO);
    //不存在该交通类型，报错
    if (transportationType == null) {
      log.debug("transportation type 不匹配，新增transportation失败");
      return -1;
    }

    String vehicleNumber = insertTransportationDTO.getVehicleNumber();
    String creatorUuid = insertTransportationDTO.getCreatorUuid();
    String scheduleTypeUuid = insertTransportationDTO.getScheduleTypeUuid();
    String scheduleUuid = insertTransportationDTO.getScheduleUuid();
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
   * @return 1:ok, 2:not found, other:exception
   */
  @Override
  public int deleteTransportation(QueryTransportationDTO queryTransportationDTO) {
    try {
      if (queryTransportationDTO.getUuid() == null) {
        return 2;
      }
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
   *
   * @return 1:ok, 2:not found, 0:exception, -1:不存在所选择的可用交通类型，需要新建对应交通类型
   */
  @Override
  public int modifyTransportation(ModifyTransportationDTO modifyTransportationDTO) {
    try {
      if (modifyTransportationDTO.getUuid() == null) {
        return 2;
      }
      //先尝试根据uuid找到需要修改的那个交通方式，找不到就直接返回2
      Transportation targetTransportation = this
          .getTransportationByUUIDWithDeleted(modifyTransportationDTO);
      if (targetTransportation == null) {
        return 2;
      }

      String transportationTypeUuid = modifyTransportationDTO.getTransportationTypeUuid();

      //如果指定了新的交通方式类型UUID，则需要检查其合法性
      if (Inspections.isNotBlank(transportationTypeUuid)) {
        //尝试查询该交通方式类型是否存在
        QueryTransportationTypeDTO queryTransportationTypeDTO = new QueryTransportationTypeDTO(
            transportationTypeUuid);
        TransportationType transportationType = transportationTypeService
            .getTransportationTypeByUUID(queryTransportationTypeDTO);
        //不存在该交通类型，报错
        if (transportationType == null) {
          log.debug("transportation type 不匹配 修改transportation失败");
          return -1;
        }
      }

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
      e.printStackTrace();
      return 0;
    }

  }
}
