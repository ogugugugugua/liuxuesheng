package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.restaurant.InsertRestaurantDTO;
import scut.yulin.trip.dto.restaurant.ModifyRestaurantDTO;
import scut.yulin.trip.dto.restaurant.QueryRestaurantDTO;
import scut.yulin.trip.model.Restaurant;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
public interface RestaurantService extends ScheduleService{
  public List<Restaurant> getRestaurantList(QueryRestaurantDTO queryRestaurantDTO);

  public Restaurant getRestaurantByUUID(QueryRestaurantDTO queryRestaurantDTO, Boolean getFullInformation);

  public int addRestaurant(InsertRestaurantDTO insertRestaurantDTO);

  public int deleteRestaurant(QueryRestaurantDTO queryRestaurantDTO);

  public int modifyRestaurant(ModifyRestaurantDTO modifyRestaurantDTO);
}
