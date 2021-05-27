package scut.yulin.admin.service.impl;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.admin.dto.traveler.InsertTravelerDTO;
import scut.yulin.admin.dto.traveler.ModifyTravelerDTO;
import scut.yulin.admin.dto.traveler.QueryTravelerDTO;
import scut.yulin.admin.mbg.mapper.TravelerDao;
import scut.yulin.admin.model.Traveler;
import scut.yulin.admin.model.TravelerExample;
import scut.yulin.admin.service.TravelerService;
import scut.yulin.common.constant.CommonConstant;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class TravelerServiceImpl implements TravelerService {

  @Autowired
  private TravelerDao dao;

  @Override
  public int addNewTraveler(InsertTravelerDTO dto) {
    return 0;
  }

  @Override
  public List<Traveler> getTravelerList(QueryTravelerDTO dto) {
    TravelerExample example = new TravelerExample();
    example.setLimit(dto.getPageSize());
    example.setOffset(dto.getOffset());
    example.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return dao.selectByExample(example);
  }

  @Override
  public Traveler getTravelerByUUID(QueryTravelerDTO dto) {
    String uuid = dto.getUuid();
    if (uuid == null) {
      return null;
    }
    TravelerExample example = new TravelerExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Traveler> travelerList = dao.selectByExample(example);
    if (travelerList.size() == 0) {
      return null;
    }
    return travelerList.get(0);
  }

  @Override
  public Traveler getTravelerByName(QueryTravelerDTO dto) {
    String accountName = dto.getAccountName();
    if (accountName == null) {
      return null;
    }
    TravelerExample example = new TravelerExample();
    example.createCriteria()
        .andAccountNameEqualTo(accountName)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<Traveler> travelerList = dao.selectByExample(example);
    if (travelerList.size() == 0) {
      return null;
    }
    return travelerList.get(0);
  }

  @Override
  public int deleteTraveler(QueryTravelerDTO dto) {
    String uuid = dto.getUuid();
    if (uuid == null) {
      return 2;
    }
    Traveler traveler = getTravelerByUUID(dto);
    if (traveler == null) {
      return 2;
    }
    TravelerExample example = new TravelerExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);
    traveler.setDeleted(CommonConstant.DELETED);
    dao.updateByExampleSelective(traveler, example);
    return 1;
  }

  @Override
  public int modifyTraveler(ModifyTravelerDTO dto) {
    return 0;
  }
}
