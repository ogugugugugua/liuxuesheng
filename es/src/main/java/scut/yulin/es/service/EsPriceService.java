package scut.yulin.es.service;

import java.util.List;
import scut.yulin.es.domain.EsPrice;
import scut.yulin.trip.model.Price;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
public interface EsPriceService {

  EsPrice transform(Price price);

  String transform(List<Price> price);
}
