package scut.yulin.es.service;

import java.util.List;
import scut.yulin.es.domain.EsTransportation;
import scut.yulin.trip.model.Transportation;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
public interface EsTransportationService {

  EsTransportation transform(Transportation transportation);

  String transform(List<Transportation> transportation);
}
