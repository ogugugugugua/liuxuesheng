package scut.yulin.es.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import scut.yulin.es.domain.EsPrice;
import scut.yulin.es.service.EsPriceService;
import scut.yulin.trip.model.Price;

/**
 * @Date 2021/6/20
 * @Author xieyulin
 * @Description TODO
 **/
@Service
public class EsPriceServiceImpl implements EsPriceService {

  @Override
  public EsPrice transform(Price price) {
    return null;
  }

  @Override
  public String transform(List<Price> price) {
    return null;
  }
}
