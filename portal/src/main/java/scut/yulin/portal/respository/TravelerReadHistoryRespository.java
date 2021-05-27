package scut.yulin.portal.respository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import scut.yulin.portal.TravelerReadHistory;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description 旅客浏览行程历史respository
 **/
public interface TravelerReadHistoryRespository extends
    MongoRepository<TravelerReadHistory, String> {

  Page<TravelerReadHistory> findByTravelerUuidOrderByCreateTimeDesc(String travelerUuid,
      Pageable pageable);

  void deleteAllByTravelerUuid(String travelerUuid);
}
