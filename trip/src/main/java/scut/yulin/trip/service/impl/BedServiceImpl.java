package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.bed.InsertBedDTO;
import scut.yulin.trip.dto.bed.ModifyBedDTO;
import scut.yulin.trip.dto.bed.QueryBedDTO;
import scut.yulin.trip.mbg.mapper.BedDao;
import scut.yulin.trip.model.Bed;
import scut.yulin.trip.model.BedExample;
import scut.yulin.trip.service.BedService;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class BedServiceImpl implements BedService {

  @Autowired
  BedDao bedDao;

  @Override
  public Bed getBedByUUID(QueryBedDTO queryBedDTO) {
    String uuid = queryBedDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    BedExample example = new BedExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Bed> bedList = bedDao.selectByExample(example);
    if (bedList.size() > 0) {
      return bedList.get(0);
    }
    return null;
  }

  @Override
  public List<Bed> getBedList(QueryBedDTO queryBedDTO) {
    BedExample example = new BedExample();
    example.setLimit(queryBedDTO.getPageSize());
    example.setOffset(queryBedDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return bedDao.selectByExample(example);
  }

  @Override
  public List<Bed> getBedListByRoomUUID(QueryBedDTO queryBedDTO) {
    String roomUuid = queryBedDTO.getRoomUuid();
    if (roomUuid == null) {
      return null;
    }

    BedExample example = new BedExample();
    example.setOffset(queryBedDTO.getOffset());
    example.setLimit(queryBedDTO.getPageSize());
    example.createCriteria()
        .andRoomUuidEqualTo(roomUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return bedDao.selectByExample(example);
  }

  @Override
  public int addNewBed(InsertBedDTO insertBedDTO) {
    String roomUuid = insertBedDTO.getRoomUuid();
    Integer numberPerson = insertBedDTO.getNumberPerson();
    String type =
        Inspections.isNotBlank(insertBedDTO.getType()) ? insertBedDTO
            .getType() : "";
    Integer quantity =
        Inspections.isNotEmpty(insertBedDTO.getQuantity()) ? insertBedDTO.getQuantity()
            : 1;

    Assert.notBlank(type, "type blank");
    Assert.notBlank(roomUuid, "roomUuid blank");

    Bed bed = new Bed(IdUtil.randomUUID(), numberPerson, type, roomUuid, quantity);
    return bedDao.insertSelective(bed);
  }

  @Override
  public int deleteBed(QueryBedDTO queryBedDTO) {
    try {
      String uuid = queryBedDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Bed bed = this.getBedByUUID(queryBedDTO);
      if (bed == null) {
        return 2;
      }
      bed.setDeleted(CommonConstant.DELETED);
      System.out.println(bed);

      BedExample example = new BedExample();
      example.createCriteria().andUuidEqualTo(uuid);
      bedDao.updateByExampleSelective(bed, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete bed failed");
      throw e;
    }
  }

  private Bed getBedByUUIDWithDeleted(QueryBedDTO queryBedDTO) {
    String uuid = queryBedDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    BedExample example = new BedExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);
    List<Bed> bedList = bedDao.selectByExample(example);
    if (bedList.size() > 0) {
      return bedList.get(0);
    }
    return null;
  }

  @Override
  public int modifyBed(ModifyBedDTO modifyBedDTO) {
    try {
      String uuid = modifyBedDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Bed targetBed = this.getBedByUUIDWithDeleted(modifyBedDTO);
      if (targetBed == null) {
        return 2;
      }

      String roomUuid = modifyBedDTO.getRoomUuid();
      Integer quantity = modifyBedDTO.getQuantity();
      String type = modifyBedDTO.getType();
      Integer numberPerson = modifyBedDTO.getNumberPerson();

      if (Inspections.isNotEmpty(quantity)) {
        targetBed.setQuantity(quantity);
      }
      if (Inspections.isNotEmpty(numberPerson)) {
        targetBed.setNumberPerson(numberPerson);
      }
      if (Inspections.isNotBlank(roomUuid)) {
        targetBed.setRoomUuid(roomUuid);
      }
      if (Inspections.isNotBlank(type)) {
        targetBed.setType(type);
      }
      targetBed.setDeleted(CommonConstant.NOT_DELETED);

      BedExample example = new BedExample();
      example.createCriteria().andUuidEqualTo(uuid);

      bedDao.updateByExampleSelective(targetBed, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify bed failed");
      return 0;
    }
  }
}
