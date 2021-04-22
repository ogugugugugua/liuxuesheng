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
import scut.yulin.trip.dto.price.InsertPriceDTO;
import scut.yulin.trip.dto.price.ModifyPriceDTO;
import scut.yulin.trip.dto.price.QueryPriceDTO;
import scut.yulin.trip.mbg.mapper.PriceDao;
import scut.yulin.trip.model.Price;
import scut.yulin.trip.model.PriceExample;
import scut.yulin.trip.service.PriceService;

/**
 * @Date 2021/4/22
 * @Author xieyulin
 * @Description TODO
 **/
@Slf4j
@Service
public class PriceServiceImpl implements PriceService {

  @Autowired
  PriceDao priceDao;

  /**
   * 根据UUID获取价格，不包含已被删除选项
   */
  @Override
  public Price getPriceByUUID(QueryPriceDTO queryPriceDTO) {
    String uuid = queryPriceDTO.getUuid();
    PriceExample example = new PriceExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<Price> priceList = priceDao.selectByExample(example);
    if (priceList.size() > 0) {
      return priceList.get(0);
    }
    return null;
  }

  @Override
  public List<Price> getPriceList(QueryPriceDTO queryPriceDTO) {
    PriceExample example = new PriceExample();
    example.setLimit(queryPriceDTO.getPageSize());
    example.setOffset(queryPriceDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return priceDao.selectByExample(example);
  }

  @Override
  public int addNewPrice(InsertPriceDTO insertPriceDTO) {
    String name = insertPriceDTO.getName();
    BigDecimal discountPrice = insertPriceDTO.getDiscountPrice();
    BigDecimal originalPrice = insertPriceDTO.getOriginalPrice();
    String creatorUuid = insertPriceDTO.getCreatorUuid();
    String scheduleUuid = insertPriceDTO.getScheduleUuid();
    String scheduleTypeUuid = insertPriceDTO.getScheduleTypeUuid();

    Assert.notBlank(creatorUuid);
    Assert.notBlank(scheduleUuid);
    Assert.notBlank(scheduleTypeUuid);
    Assert.notNull(discountPrice);
    Assert.notNull(originalPrice);
    Assert.notBlank(name);

    Price price = new Price(IdUtil.randomUUID(), scheduleTypeUuid, scheduleUuid, name,
        originalPrice, discountPrice,
        creatorUuid);

    return priceDao.insertSelective(price);
  }

  /**
   * @return 1:ok, 2:not found, 0:exception
   */
  @Override
  public int deletePrice(QueryPriceDTO queryPriceDTO) {
    try {
      Price price = this.getPriceByUUID(queryPriceDTO);
      if (price == null) {
        log.debug("deletePrice not found");
        return 2;
      }
      price.setDeleted(CommonConstant.DELETED);

      PriceExample example = new PriceExample();
      example.createCriteria().andUuidEqualTo(queryPriceDTO.getUuid());

      priceDao.updateByExampleSelective(price, example);
      return 1;
    } catch (Exception e) {
      log.debug("deletePrice failed");
      return 0;
    }
  }

  /**
   * 根据UUID获取价格，不包含已被删除选项
   */
  public Price getPriceByUUIDWithDeleted(QueryPriceDTO queryPriceDTO) {
    String uuid = queryPriceDTO.getUuid();
    PriceExample example = new PriceExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);

    List<Price> priceList = priceDao.selectByExample(example);
    if (priceList.size() > 0) {
      return priceList.get(0);
    }
    return null;
  }

  /**
   * @return 1:ok, 2:not found, 0:exception
   */
  @Override
  public int modifyPrice(ModifyPriceDTO modifyPriceDTO) {
    try {
      Price targetPrice = this.getPriceByUUIDWithDeleted(modifyPriceDTO);
      if (targetPrice == null) {
        return 2;
      }

      BigDecimal discountPrice = modifyPriceDTO.getDiscountPrice();
      BigDecimal originalPrice = modifyPriceDTO.getOriginalPrice();
      String name = modifyPriceDTO.getName();
      String scheduleUuid = modifyPriceDTO.getScheduleUuid();
      String scheduleTypeUuid = modifyPriceDTO.getScheduleTypeUuid();

      if (Inspections.isNotBlank(name)) {
        targetPrice.setName(name);
      }
      if (Inspections.isNotBlank(scheduleTypeUuid)) {
        targetPrice.setScheduleTypeUuid(scheduleTypeUuid);
      }
      if (Inspections.isNotBlank(scheduleUuid)) {
        targetPrice.setScheduleUuid(scheduleUuid);
      }
      if (Inspections.isNotEmpty(discountPrice)) {
        targetPrice.setDiscountPrice(discountPrice);
      }
      if (Inspections.isNotEmpty(originalPrice)) {
        targetPrice.setDiscountPrice(originalPrice);
      }
      targetPrice.setDeleted(CommonConstant.NOT_DELETED);

      PriceExample example = new PriceExample();
      example.createCriteria().andUuidEqualTo(modifyPriceDTO.getUuid());

      priceDao.updateByExampleSelective(targetPrice, example);
      return 1;
    } catch (Exception e) {
      log.debug("modifyPrice failed");
      return 0;
    }
  }
}
