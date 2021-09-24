package scut.yulin.es.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import scut.yulin.es.domain.EsTransportation;
import scut.yulin.es.service.EsTransportationService;
import scut.yulin.trip.model.Transportation;

/**
 * @Date 2021/6/20
 * @Author xieyulin
 * @Description TODO
 **/
@Service
public class EsTransportationServiceImpl implements EsTransportationService {

  @Override
  public EsTransportation transform(Transportation transportation) {
    return null;
  }

  @Override
  public String transform(List<Transportation> transportation) {
    return null;
  }
}
