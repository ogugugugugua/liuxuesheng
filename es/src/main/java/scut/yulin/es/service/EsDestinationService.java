package scut.yulin.es.service;

import java.util.List;
import org.springframework.data.domain.Page;
import scut.yulin.es.domain.esDestination;
import scut.yulin.trip.model.Destination;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
public interface EsDestinationService {

  /**
   * 从数据库中导入所有商品到ES
   */
  int importAll();

  /**
   * 根据id删除商品
   */
  void delete(Long id);

  /**
   * 根据id创建商品
   */
  esDestination create(String uuid);

  /**
   * 批量删除商品
   */
  void delete(List<Long> ids);

  esDestination test4();

  /**
   * 根据关键字搜索名称或者副标题
   */
  Page<esDestination> findByLocalNameOrCnNameOrDescriptionOrCityOrCountryUuidOrLocationOrSpecialRequirement(
      String localName, String cnName, String description, String city, String countryUuid,
      String location, String specialRequirement, Integer pageNum, Integer pageSize
  );

  /**
   * 类型转换函数
   */
  esDestination transform(Destination destination);
}
