package scut.yulin.es;

import cn.hutool.core.util.IdUtil;
import java.util.Locale;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.es.domain.esDestination;
import scut.yulin.es.repository.EsDestinationRepository;
import scut.yulin.trip.dto.destination.QueryDestinationDTO;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.model.Destination;
import scut.yulin.trip.model.Image;
import scut.yulin.trip.model.Price;
import scut.yulin.trip.model.Transportation;
import scut.yulin.trip.service.DestinationService;

@SpringBootTest
class EsApplicationTests {
//  @Autowired
//  EsImageService esImageService;
//  @Autowired
//  EsCommentService esCommentService;
//  @Autowired
//  EsPriceService esPriceService;
//  @Autowired
//  EsTransportationService esTransportationService;
  @Autowired
  DestinationService destinationService;
  @Autowired
  EsDestinationRepository repository;
  @Test
  void contextLoads() {
    String uuid = "589a9181-b9fc-4e78-bbcf-4d44e16a696a";
    Destination d = destinationService
        .getDestinationByUUID(new QueryDestinationDTO(uuid), true);
    esDestination es = new esDestination();
    es.setSpecialRequirement(d.getSpecialRequirement().toLowerCase(Locale.ROOT));
    es.setRating(d.getRating());
    es.setLocation(d.getLocation().toLowerCase(Locale.ROOT));
    es.setDescription(d.getDescription().toLowerCase(Locale.ROOT));
    es.setLocalName(d.getLocalName().toLowerCase(Locale.ROOT));
    es.setCnName(d.getCnName().toLowerCase(Locale.ROOT));
    es.setCity(d.getCity().toLowerCase(Locale.ROOT));
    es.setScheduleTypeUuid(CommonConstant.SCHEDULE_TYPE_DESTINATION.toLowerCase(Locale.ROOT));
    es.setId(1L);
    es.setCommentList(String.valueOf(d.getCommentList().stream().map(Comment::getContent).collect(
        Collectors.toList())).toLowerCase(Locale.ROOT));
    es.setImageList(
        String.valueOf(d.getImageList().stream().map(Image::getUrl).collect(Collectors.toList())).toLowerCase(Locale.ROOT));
    es.setTransportationList(String
        .valueOf(d.getTransportationList().stream().map(Transportation::getVehicleNumber).collect(
            Collectors.toList())).toLowerCase(Locale.ROOT));
    es.setPriceList(String.valueOf(d.getPriceList().stream().map(Price::getDiscountPrice).count()).toLowerCase(Locale.ROOT));
    es.setUuid(IdUtil.randomUUID().toLowerCase(Locale.ROOT));

    System.out.println(es.toString());

    esDestination save = repository.save(es);
    System.out.println("save====> "+save);
  }

  @Test
  void test2() {
    Page<esDestination> result = repository
        .findByLocalNameOrCnNameOrDescriptionOrCityOrCountryUuidOrLocationOrSpecialRequirement(
            " de", null, null, null, null, null, null, PageRequest.of(1, 10));
    System.out.println(result.getTotalPages());
    System.out.println(result.getContent());
  }

  @Test
  void test3() {
    Page<esDestination> result = repository
        .findAll(PageRequest.of(1, 10));
    System.out.println(result.getTotalPages());
    System.out.println(result.getContent());
  }
}
