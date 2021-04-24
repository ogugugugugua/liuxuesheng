package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.restaurant.InsertRestaurantDTO;
import scut.yulin.trip.dto.restaurant.ModifyRestaurantDTO;
import scut.yulin.trip.dto.restaurant.QueryRestaurantDTO;
import scut.yulin.trip.service.RestaurantService;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
@RestController
@RequestMapping("schedule")
public class RestaurantController {

  @Autowired
  RestaurantService restaurantService;

  @GetMapping("restaurant")
  public ResponseVO getRestaurantByUUID(@RequestBody QueryRestaurantDTO queryRestaurantDTO) {
    return ResponseVO.success(restaurantService.getRestaurantByUUID(queryRestaurantDTO,true));
  }

  @GetMapping("restaurant/list")
  public ResponseVO getRestaurantList(@RequestBody QueryRestaurantDTO queryRestaurantDTO) {
    return ResponseVO.success(restaurantService.getRestaurantList(queryRestaurantDTO));
  }

  @PostMapping("restaurant")
  public ResponseVO addNewRestaurant(@RequestBody InsertRestaurantDTO insertRestaurantDTO) {
    int status = restaurantService.addRestaurant(insertRestaurantDTO);
    if (status == 1) {
      return ResponseVO.success("add new restaurant ok");
    }
    return ResponseVO.failed("add new restaurant failed");
  }

  @DeleteMapping("restaurant")
  public ResponseVO deleteRestaurant(@RequestBody QueryRestaurantDTO queryRestaurantDTO) {
    int status = restaurantService.deleteRestaurant(queryRestaurantDTO);
    if (status == 1) {
      return ResponseVO.success("delete restaurant ok");
    }
    if (status == 2) {
      return ResponseVO.failed("delete restaurant not found");
    }
    return ResponseVO.failed("delete restaurant failed");
  }

  @PutMapping("restaurant")
  public ResponseVO modifyRestaurant(@RequestBody ModifyRestaurantDTO modifyRestaurantDTO) {
    int status = restaurantService.modifyRestaurant(modifyRestaurantDTO);
    if (status == 1) {
      return ResponseVO.success("modify restaurant ok");
    }
    if (status == 2) {
      return ResponseVO.failed("modify restaurant not found");
    }
    return ResponseVO.failed("modify restaurant failed");
  }
}
