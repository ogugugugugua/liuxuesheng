package scut.yulin.es.service.impl;

import cn.hutool.core.util.IdUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.es.domain.esDestination;
import scut.yulin.es.repository.EsDestinationRepository;
import scut.yulin.es.service.EsCommentService;
import scut.yulin.es.service.EsDestinationService;
import scut.yulin.es.service.EsImageService;
import scut.yulin.es.service.EsPriceService;
import scut.yulin.es.service.EsTransportationService;
import scut.yulin.trip.dto.destination.QueryDestinationDTO;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.model.Destination;
import scut.yulin.trip.model.Image;
import scut.yulin.trip.model.Price;
import scut.yulin.trip.model.Transportation;
import scut.yulin.trip.service.DestinationService;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
@Service
public class EsDestinationServiceImpl implements EsDestinationService {

  @Autowired
  EsImageService esImageService;
  @Autowired
  EsCommentService esCommentService;
  @Autowired
  EsPriceService esPriceService;
  @Autowired
  EsTransportationService esTransportationService;
  @Autowired
  DestinationService destinationService;
  @Autowired
  EsDestinationRepository repository;

  @Override
  public int importAll() {
    List<Destination> destinationList = destinationService
        .getDestinationList(new QueryDestinationDTO());
    List<esDestination> esDestinationList = new ArrayList<>();
    for (Destination destination : destinationList) {
      esDestinationList.add(transform(destination));
    }
    Iterable<esDestination> esDestinationIterable = repository.saveAll(esDestinationList);
    Iterator<esDestination> iterator = esDestinationIterable.iterator();
    int result = 0;
    while (iterator.hasNext()) {
      result++;
      iterator.next();
    }
    return result;
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public esDestination create(String uuid) {
    Destination destinationByUUID = destinationService
        .getDestinationByUUID(new QueryDestinationDTO(uuid), true);
    esDestination esDestination = transform(destinationByUUID);
    return repository.save(esDestination);
//    return null;
  }

  @Override
  public void delete(List<Long> ids) {

  }
  @Override
  public esDestination test4() {
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
    return save;
  }

  @Override
  public Page<esDestination> findByLocalNameOrCnNameOrDescriptionOrCityOrCountryUuidOrLocationOrSpecialRequirement(
      String localName, String cnName, String description, String city, String countryUuid,
      String location, String specialRequirement, Integer pageNum, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    return repository
        .findByLocalNameOrCnNameOrDescriptionOrCityOrCountryUuidOrLocationOrSpecialRequirement(
            localName, cnName, description, city, countryUuid, location, specialRequirement,
            pageable);
  }

  @Override
  public esDestination transform(Destination destination) {
    esDestination result = new esDestination();
    result.setLocation(destination.getLocation());
    result.setCity(destination.getCity());
    result.setCountryUuid(destination.getCountryUuid());
    result.setCnName(destination.getCnName());
    result.setLocalName(destination.getLocalName());
    result.setDescription(destination.getDescription());
    result.setUuid(destination.getUuid());
    result.setScheduleTypeUuid(destination.getScheduleTypeUuid());
    result.setRating(destination.getRating());
    result.setSpecialRequirement(destination.getSpecialRequirement());

    result.setCommentList(esCommentService.transform(destination.getCommentList()));
    result.setImageList(esImageService.transform(destination.getImageList()));
    result.setPriceList(esPriceService.transform(destination.getPriceList()));
    result.setTransportationList(
        esTransportationService.transform(destination.getTransportationList()));
    return result;
  }
}
