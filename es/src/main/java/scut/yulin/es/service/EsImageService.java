package scut.yulin.es.service;

import java.util.List;
import org.springframework.stereotype.Service;
import scut.yulin.es.domain.EsImage;
import scut.yulin.trip.model.Image;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
public interface EsImageService {

  EsImage transform(Image image);

  String transform(List<Image> image);
}
