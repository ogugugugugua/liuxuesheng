package scut.yulin.es.repository;

import java.math.BigDecimal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import scut.yulin.es.domain.esDestination;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
public interface EsDestinationRepository extends ElasticsearchRepository<esDestination, Long> {

  @Override
  Page<esDestination> findAll(Pageable pageable);

  /**
   * 搜索查询
   */
  Page<esDestination> findByLocalNameOrCnNameOrDescriptionOrCityOrCountryUuidOrLocationOrSpecialRequirement(
      String localName, String cnName, String description, String city, String countryUuid,
      String location, String specialRequirement, Pageable page
  );

  /**
   * 根据评分查询
   */
  Page<esDestination> findByRatingGreaterThan(BigDecimal rating, Pageable page);

}
