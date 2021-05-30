package scut.yulin.portal.service.impl;

import cn.hutool.core.util.IdUtil;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import scut.yulin.admin.service.TravelerAdminService;
import scut.yulin.mbg.model.Traveler;
import scut.yulin.portal.TravelerReadHistory;
import scut.yulin.portal.respository.TravelerReadHistoryRespository;
import scut.yulin.portal.service.TravelerReadHistoryService;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description 旅客浏览行程历史Service
 **/
@Service
@Slf4j
public class TravelerReadHistoryServiceImpl implements TravelerReadHistoryService {

  @Autowired
  private TravelerReadHistoryRespository respository;
  @Autowired
  private TravelerAdminService travelerService;
//  @Autowired
//  ResourceService resourceService;


  @Override
  public int addNewTravelerReadHistory(TravelerReadHistory history) {
    Traveler traveler = travelerService.getCurrentTraveler();
    history.setTravelerUuid(traveler.getUuid());
    history.setTravelerName(traveler.getAccountName());
    history.setUuid(IdUtil.randomUUID());
    history.setCreateTime(new Date());

    respository.save(history);
    return 1;
  }

  @Override
  public Page<TravelerReadHistory> getTravelerReadHistoryList(Integer pageNum, Integer pageSize) {
    Traveler traveler = travelerService.getCurrentTraveler();
    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);

    return respository.findByTravelerUuidOrderByCreateTimeDesc(traveler.getUuid(), pageable);
  }

}
