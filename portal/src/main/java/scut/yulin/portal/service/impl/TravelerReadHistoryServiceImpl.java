package scut.yulin.portal.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
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
  private TravelerReadHistoryRespository repository;

  @Override
  public int addNewTravelerReadHistory(TravelerReadHistory history) {
    return 0;
  }

  @Override
  public Page<TravelerReadHistory> getTravelerReadHistoryList(Integer pageNum, Integer pageSize) {
    return null;
  }

}
