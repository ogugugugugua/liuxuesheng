package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.menu.InsertMenuDTO;
import scut.yulin.trip.dto.menu.ModifyMenuDTO;
import scut.yulin.trip.dto.menu.QueryMenuDTO;
import scut.yulin.trip.model.Menu;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
public interface MenuService {
  public Menu getMenuByUUID(QueryMenuDTO queryMenuDTO);

  public List<Menu> getMenuList(QueryMenuDTO queryMenuDTO);

  public List<Menu> getMenuListByScheduleUUID(QueryMenuDTO queryMenuDTO);

  public int addNewMenu(InsertMenuDTO insertMenuDTO);

  public int deleteMenu(QueryMenuDTO queryMenuDTO);

  public int modifyMenu(ModifyMenuDTO modifyMenuDTO);
}
