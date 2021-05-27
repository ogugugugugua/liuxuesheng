package scut.yulin.portal.service;

import org.springframework.data.domain.Page;
import scut.yulin.portal.TravelerReadHistory;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description 旅客浏览行程历史Service
 **/
public interface TravelerReadHistoryService {

  public int addNewTravelerReadHistory(TravelerReadHistory history);

  public Page<TravelerReadHistory> getTravelerReadHistoryList(Integer pageNum, Integer pageSize);
}
