package scut.yulin.es.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import scut.yulin.es.domain.EsDestination;
import scut.yulin.es.repository.EsDestinationRepository;
import scut.yulin.es.service.EsCommentService;
import scut.yulin.es.service.EsDestinationService;
import scut.yulin.es.service.EsImageService;
import scut.yulin.es.service.EsPriceService;
import scut.yulin.es.service.EsTransportationService;
import scut.yulin.trip.dto.destination.QueryDestinationDTO;
import scut.yulin.trip.model.Destination;
import scut.yulin.trip.service.DestinationService;

/**
 * @Date 2021/6/18
 * @Author xieyulin
 * @Description TODO
 **/
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
    List<EsDestination> esDestinationList = new ArrayList<>();
    for (Destination destination : destinationList) {
      esDestinationList.add(transform(destination));
    }
    Iterable<EsDestination> esDestinationIterable = repository.saveAll(esDestinationList);
    Iterator<EsDestination> iterator = esDestinationIterable.iterator();
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
  public EsDestination create(String uuid) {
    Destination destinationByUUID = destinationService
        .getDestinationByUUID(new QueryDestinationDTO(uuid), true);
    EsDestination esDestination = transform(destinationByUUID);
    return repository.save(esDestination);
//    return null;
  }

  @Override
  public void delete(List<Long> ids) {

  }

  @Override
  public Page<EsDestination> findByLocalNameOrCnNameOrDescriptionOrCityOrCountryUuidOrLocationOrSpecialRequirement(
      String localName, String cnName, String description, String city, String countryUuid,
      String location, String specialRequirement, Integer pageNum, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNum, pageSize);
    return repository
        .findByLocalNameOrCnNameOrDescriptionOrCityOrCountryUuidOrLocationOrSpecialRequirement(
            localName, cnName, description, city, countryUuid, location, specialRequirement,
            pageable);
  }

  @Override
  public EsDestination transform(Destination destination) {
    EsDestination result = new EsDestination();
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
