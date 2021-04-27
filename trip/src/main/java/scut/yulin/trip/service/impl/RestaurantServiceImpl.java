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
import scut.yulin.trip.dto.comment.QueryCommentDTO;
import scut.yulin.trip.dto.image.QueryImageDTO;
import scut.yulin.trip.dto.menu.QueryMenuDTO;
import scut.yulin.trip.dto.restaurant.InsertRestaurantDTO;
import scut.yulin.trip.dto.restaurant.ModifyRestaurantDTO;
import scut.yulin.trip.dto.restaurant.QueryRestaurantDTO;
import scut.yulin.trip.dto.transportation.QueryTransportationDTO;
import scut.yulin.trip.mbg.mapper.RestaurantDao;
import scut.yulin.trip.model.Comment;
import scut.yulin.trip.model.Image;
import scut.yulin.trip.model.Menu;
import scut.yulin.trip.model.Restaurant;
import scut.yulin.trip.model.RestaurantExample;
import scut.yulin.trip.model.Schedule;
import scut.yulin.trip.model.Transportation;
import scut.yulin.trip.service.CommentService;
import scut.yulin.trip.service.ImageService;
import scut.yulin.trip.service.MenuService;
import scut.yulin.trip.service.RestaurantService;
import scut.yulin.trip.service.TransportationService;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

  @Autowired
  RestaurantDao restaurantDao;

  @Autowired
  TransportationService transportationService;

  @Autowired
  MenuService menuService;

  @Autowired
  ImageService imageService;

  @Autowired
  CommentService commentService;

  @Override
  public List<Restaurant> getRestaurantList(QueryRestaurantDTO queryRestaurantDTO) {
    RestaurantExample example = new RestaurantExample();
    example.setLimit(queryRestaurantDTO.getPageSize());
    example.setOffset(queryRestaurantDTO.getOffset());

    example.createCriteria().andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return restaurantDao.selectByExample(example);
  }

  @Override
  public Restaurant getRestaurantByUUID(QueryRestaurantDTO queryRestaurantDTO,
      Boolean getFullInformation) {
    String scheduleUUID = queryRestaurantDTO.getUuid();
    if (scheduleUUID == null) {
      log.debug("UUID not found");
      return null;
    }

    RestaurantExample example = new RestaurantExample();
    example.createCriteria()
        .andUuidEqualTo(scheduleUUID)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<Restaurant> restaurantList = restaurantDao.selectByExample(example);
    if (restaurantList.size() == 0) {
      log.debug("restaurant not found");
      return null;
    }

    Restaurant targetRestaurant = restaurantList.get(0);

    if (getFullInformation) {
      List<Transportation> transportationList = transportationService
          .getTransportationListByScheduleUUID(new QueryTransportationDTO(null, scheduleUUID));
      List<Menu> menuList = menuService
          .getMenuListByScheduleUUID((new QueryMenuDTO(null, scheduleUUID)));
      List<Image> imageList = imageService
          .getImageListByScheduleUUID(new QueryImageDTO(null, scheduleUUID, null, null));
      List<Comment> commentList = commentService
          .getCommentListByScheduleUUID(new QueryCommentDTO(null, scheduleUUID, null, null, null));

      for (int i = 0; i < transportationList.size(); i++) {
        String uuid = transportationList.get(i).getUuid();
        Transportation transportationWithFullInformation = transportationService
            .getTransportationByUUID(new QueryTransportationDTO(uuid, null));
        transportationList.set(i, transportationWithFullInformation);
      }

      targetRestaurant.setTransportationList(transportationList);
      targetRestaurant.setMenuList(menuList);
      targetRestaurant.setImageList(imageList);
      targetRestaurant.setCommentList(commentList);
    }

    return targetRestaurant;
  }

  @Override
  public int addRestaurant(InsertRestaurantDTO insertRestaurantDTO) {
    String cnName = Inspections.isNotBlank(insertRestaurantDTO.getCnName()) ? insertRestaurantDTO
        .getCnName() : "";
    String countryUuid =
        Inspections.isNotBlank(insertRestaurantDTO.getCountryUuid()) ? insertRestaurantDTO
            .getCountryUuid() : "";
    BigDecimal rating =
        Inspections.isNotEmpty(insertRestaurantDTO.getRating()) ? insertRestaurantDTO.getRating()
            : new BigDecimal("5");
    String url =
        Inspections.isNotBlank(insertRestaurantDTO.getUrl()) ? insertRestaurantDTO.getUrl() : "";
    String city = insertRestaurantDTO.getCity();
    Integer stars = insertRestaurantDTO.getStars();
    String localName = insertRestaurantDTO.getLocalName();
    String location = insertRestaurantDTO.getLocation();

    Assert.notBlank(city, "city blank");
    Assert.notNull(stars, "star blank");
    Assert.notBlank(localName, "localName blank");
    Assert.notBlank(location, "location blank");

    Restaurant restaurant = new Restaurant(IdUtil.randomUUID(), stars, localName, cnName, city,
        countryUuid, location, rating, url);
    return restaurantDao.insertSelective(restaurant);
  }

  @Override
  public int deleteRestaurant(QueryRestaurantDTO queryRestaurantDTO) {
    try {
      String uuid = queryRestaurantDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Restaurant targetRestaurant = this.getRestaurantByUUID(queryRestaurantDTO, false);
      if (targetRestaurant == null) {
        return 2;
      }

      targetRestaurant.setDeleted(CommonConstant.DELETED);

      RestaurantExample example = new RestaurantExample();
      example.createCriteria().andUuidEqualTo(uuid);

      restaurantDao.updateByExampleSelective(targetRestaurant, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete restaurant failed " + e.getMessage());
      throw e;
    }
  }

  private Restaurant getRestaurantByUUIDWithDeleted(QueryRestaurantDTO queryRestaurantDTO) {
    String uuid = queryRestaurantDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    RestaurantExample example = new RestaurantExample();
    example.createCriteria().andUuidEqualTo(uuid);

    List<Restaurant> restaurantList = restaurantDao.selectByExample(example);
    if (restaurantList.size() > 0) {
      return restaurantList.get(0);
    }
    return null;
  }


  @Override
  public int modifyRestaurant(ModifyRestaurantDTO modifyRestaurantDTO) {
    try {
      String uuid = modifyRestaurantDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Restaurant targetRestaurant = this.getRestaurantByUUIDWithDeleted(modifyRestaurantDTO);
      if (targetRestaurant == null) {
        return 2;
      }

      String cnName = modifyRestaurantDTO.getCnName();
      String countryUuid = modifyRestaurantDTO.getCountryUuid();
      BigDecimal rating = modifyRestaurantDTO.getRating();
      String url = modifyRestaurantDTO.getUrl();
      String city = modifyRestaurantDTO.getCity();
      Integer stars = modifyRestaurantDTO.getStars();
      String localName = modifyRestaurantDTO.getLocalName();
      String location = modifyRestaurantDTO.getLocation();

      if (Inspections.isNotBlank(cnName)) {
        targetRestaurant.setCnName(cnName);
      }
      if (Inspections.isNotBlank(countryUuid)) {
        targetRestaurant.setCountryUuid(countryUuid);
      }
      if (Inspections.isNotEmpty(rating)) {
        targetRestaurant.setRating(rating);
      }
      if (Inspections.isNotBlank(url)) {
        targetRestaurant.setUrl(url);
      }
      if (Inspections.isNotBlank(city)) {
        targetRestaurant.setCity(city);
      }
      if (Inspections.isNotEmpty(stars)) {
        targetRestaurant.setStars(stars);
      }
      if (Inspections.isNotBlank(localName)) {
        targetRestaurant.setLocalName(localName);
      }
      if (Inspections.isNotBlank(location)) {
        targetRestaurant.setLocation(location);
      }
      targetRestaurant.setDeleted(CommonConstant.NOT_DELETED);

      RestaurantExample example = new RestaurantExample();
      example.createCriteria().andUuidEqualTo(uuid);

      restaurantDao.updateByExampleSelective(targetRestaurant, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify restaurant failed" + e.getMessage());
      throw e;
    }
  }

  @Override
  public Schedule getScheduleByUUID(String uuid, Boolean getFullInformation) {
    if (uuid == null) {
      return null;
    }
    return this.getRestaurantByUUID(new QueryRestaurantDTO(uuid), getFullInformation);
  }

}
