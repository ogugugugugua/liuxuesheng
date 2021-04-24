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
import scut.yulin.trip.dto.menu.InsertMenuDTO;
import scut.yulin.trip.dto.menu.ModifyMenuDTO;
import scut.yulin.trip.dto.menu.QueryMenuDTO;
import scut.yulin.trip.mbg.mapper.MenuDao;
import scut.yulin.trip.model.Menu;
import scut.yulin.trip.model.MenuExample;
import scut.yulin.trip.service.MenuService;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

  @Autowired
  MenuDao menuDao;

  /**
   * 根据UUID获取菜单，不包含已被删除选项
   */
  @Override
  public Menu getMenuByUUID(QueryMenuDTO queryMenuDTO) {
    String uuid = queryMenuDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    MenuExample example = new MenuExample();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);

    List<Menu> menuList = menuDao.selectByExample(example);
    if (menuList.size() > 0) {
      return menuList.get(0);
    }
    return null;
  }

  @Override
  public List<Menu> getMenuList(QueryMenuDTO queryMenuDTO) {
    MenuExample example = new MenuExample();
    example.setLimit(queryMenuDTO.getPageSize());
    example.setOffset(queryMenuDTO.getOffset());
    example.createCriteria()
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return menuDao.selectByExample(example);
  }

  @Override
  public List<Menu> getMenuListByScheduleUUID(QueryMenuDTO queryMenuDTO) {
    String scheduleUuid = queryMenuDTO.getRestaurantUuid();
    if (scheduleUuid == null) {
      return null;
    }

    MenuExample example = new MenuExample();
    example.setLimit(queryMenuDTO.getPageSize());
    example.setOffset(queryMenuDTO.getOffset());
    example.createCriteria()
        .andRestaurantUuidEqualTo(scheduleUuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    return menuDao.selectByExample(example);
  }

  @Override
  public int addNewMenu(InsertMenuDTO insertMenuDTO) {
    String name = insertMenuDTO.getName();
    //TODO: check restaurantUuid availability
    String restaurantUuid = insertMenuDTO.getRestaurantUuid();
    String description =
        Inspections.isNotBlank(insertMenuDTO.getDescription()) ? insertMenuDTO.getDescription()
            : "";
    BigDecimal price = Inspections.isNotEmpty(insertMenuDTO.getPrice()) ? insertMenuDTO.getPrice()
        : new BigDecimal("-1");

    Assert.notBlank(name, "name blank");
    Assert.notBlank(restaurantUuid, "restaurantUuid blank");

    Menu menu = new Menu(IdUtil.randomUUID(), restaurantUuid, name, description, price);
    return menuDao.insertSelective(menu);
  }

  /**
   *
   * @param queryMenuDTO
   * @return 1:ok, 2:not found, other:exception
   */
  @Override
  public int deleteMenu(QueryMenuDTO queryMenuDTO) {
    try {
      String uuid = queryMenuDTO.getUuid();
      if (uuid == null) {
        return 2;
      }
      Menu targetMenu = this.getMenuByUUID(queryMenuDTO);
      if (targetMenu == null) {
        return 2;
      }
      targetMenu.setDeleted(CommonConstant.DELETED);
      MenuExample example = new MenuExample();
      example.createCriteria().andUuidEqualTo(uuid);

      menuDao.updateByExampleSelective(targetMenu, example);
      return 1;
    } catch (Exception e) {
      log.debug("delete menu failed");
      throw e;
    }
  }

  private Menu getMenuByUUIDWithDeleted(QueryMenuDTO queryMenuDTO) {
    String uuid = queryMenuDTO.getUuid();
    if (uuid == null) {
      return null;
    }
    MenuExample example = new MenuExample();
    example.createCriteria()
        .andUuidEqualTo(uuid);

    List<Menu> menuList = menuDao.selectByExample(example);
    if (menuList.size() > 0) {
      return menuList.get(0);
    }
    return null;
  }

  /**
   *
   * @param modifyMenuDTO
   * @return 1:ok, 2:not found, other:exception
   */
  @Override
  public int modifyMenu(ModifyMenuDTO modifyMenuDTO) {
    try {

      String uuid = modifyMenuDTO.getUuid();
      if (uuid == null) {
        return 2;
      }

      Menu targetMenu = this.getMenuByUUIDWithDeleted(modifyMenuDTO);
      if (targetMenu == null) {
        return 2;
      }

      String description = modifyMenuDTO.getDescription();
      String name = modifyMenuDTO.getName();
      BigDecimal price = modifyMenuDTO.getPrice();
      String restaurantUuid = modifyMenuDTO.getRestaurantUuid();

      if (Inspections.isNotBlank(description)) {
        targetMenu.setDescription(description);
      }
      if (Inspections.isNotBlank(name)) {
        targetMenu.setName(name);
      }
      if (Inspections.isNotBlank(restaurantUuid)) {
        targetMenu.setRestaurantUuid(restaurantUuid);
      }
      if (Inspections.isNotEmpty(price)) {
        targetMenu.setPrice(price);
      }
      targetMenu.setDeleted(CommonConstant.NOT_DELETED);

      MenuExample example = new MenuExample();
      example.createCriteria().andUuidEqualTo(uuid);
      menuDao.updateByExampleSelective(targetMenu, example);
      return 1;
    } catch (Exception e) {
      log.debug("modify menu failed");
      throw e;
    }
  }
}
