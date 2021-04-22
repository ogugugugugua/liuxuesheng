package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.transportationType.InsertTransportationTypeDTO;
import scut.yulin.trip.dto.transportationType.ModifyTransportationTypeDTO;
import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.mbg.mapper.TransportationTypeDao;
import scut.yulin.trip.model.TransportationType;
import scut.yulin.trip.model.TransportationTypeExample;
import scut.yulin.trip.service.TransportationTypeService;

@Service
@Slf4j
public class TransportationTypeServiceImpl implements TransportationTypeService {

  @Autowired
  TransportationTypeDao transportationTypeDao;

  /**
   * 根据UUID获取可用交通方式类型，不包含已被逻辑删除项
   */
  @Override
  public TransportationType getTransportationTypeByUUID(
      QueryTransportationTypeDTO queryTransportationTypeDTO) {
    TransportationTypeExample example = new TransportationTypeExample();
    String uuid = queryTransportationTypeDTO.getUuid();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TransportationType> transportationTypes = transportationTypeDao.selectByExample(example);
    if (transportationTypes.size() > 0) {
      return transportationTypes.get(0);
    }
    return null;
  }

  /**
   * 类内方法，不向外暴露 通过UUID查询可用交通类型，包括已经删除的项 可以用于
   */
  public TransportationType getTransportationTypeByUUIDWithDeleted(
      QueryTransportationTypeDTO queryTransportationTypeDTO) {
    TransportationTypeExample example = new TransportationTypeExample();
    String uuid = queryTransportationTypeDTO.getUuid();
    example.createCriteria()
        .andUuidEqualTo(uuid);
    List<TransportationType> transportationTypes = transportationTypeDao.selectByExample(example);
    if (transportationTypes.size() > 0) {
      return transportationTypes.get(0);
    }
    return null;
  }

  /**
   * 增加可用交通类型
   */
  @Override
  public int addNewTransportationType(InsertTransportationTypeDTO insertTransportationTypeDTO) {
    String type = insertTransportationTypeDTO.getType();
    String creatorUuid = Inspections.isNotBlank(insertTransportationTypeDTO.getCreatorUuid())
        ? insertTransportationTypeDTO.getCreatorUuid() : "defaultTrasportationTypeCreatorName";
    String cnName = insertTransportationTypeDTO.getCnName();

    Assert.notBlank(creatorUuid);
    Assert.notBlank(type);
    Assert.notBlank(cnName);

    TransportationType transportationType = new TransportationType(IdUtil.randomUUID(),
        type, cnName, creatorUuid);

    return transportationTypeDao.insertSelective(transportationType);
  }

  /**
   * 查询所有可用交通类型，不包含已被逻辑删除项
   */
  @Override
  public List<TransportationType> getTransportationTypeList(
      QueryTransportationTypeDTO queryTransportationTypeDTO) {
    TransportationTypeExample example = new TransportationTypeExample();
    example.setLimit(queryTransportationTypeDTO.getPageSize());
    example.setOffset(queryTransportationTypeDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return transportationTypeDao.selectByExample(example);
  }

  /**
   * 逻辑删除可用交通类型
   *
   * @return 1:ok, 2:not found, 0:exception
   */
  @Override
  public int deleteTrasportationType(QueryTransportationTypeDTO queryTransportationTypeDTO) {
    try {
      TransportationType targerTransportationType = this
          .getTransportationTypeByUUID(queryTransportationTypeDTO);
      if (targerTransportationType == null) {
        log.debug("delete Trasportation Type not found");
        return 2;
      }

      targerTransportationType.setDeleted(CommonConstant.DELETED);

      TransportationTypeExample example = new TransportationTypeExample();
      example.createCriteria().andUuidEqualTo(queryTransportationTypeDTO.getUuid());

      transportationTypeDao.updateByExampleSelective(targerTransportationType, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete Trasportation Type exception==>" + e);
      return 0;
    }
  }

  /**
   * 修改可用交通类型 包括将已被逻辑删除的可用交通类型设置为未删除
   *
   * @return 1:ok;  0:ko; 2:not found
   */
  @Override
  public int modifyTrasportationType(ModifyTransportationTypeDTO modifyTransportationTypeDTO) {
    try {
      TransportationType targerTransportationType = this
          .getTransportationTypeByUUIDWithDeleted(modifyTransportationTypeDTO);
      if (targerTransportationType == null) {
        return 2;
      }

      String type = modifyTransportationTypeDTO.getType();
      String cnName = modifyTransportationTypeDTO.getCnName();

      if (Inspections.isNotBlank(type)) {
        targerTransportationType.setType(type);
      }
      if (Inspections.isNotBlank(cnName)) {
        targerTransportationType.setCnName(cnName);
      }
      targerTransportationType.setDeleted(CommonConstant.NOT_DELETED);

      TransportationTypeExample example = new TransportationTypeExample();
      example.createCriteria().andUuidEqualTo(modifyTransportationTypeDTO.getUuid());

      transportationTypeDao.updateByExampleSelective(targerTransportationType, example);
      return 1;
    } catch (Exception e) {
      log.debug("modifyTrasportationType exception==>" + e);
      return 0;
    }
  }

}
