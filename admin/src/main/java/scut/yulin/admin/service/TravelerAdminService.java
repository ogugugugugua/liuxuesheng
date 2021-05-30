package scut.yulin.admin.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import scut.yulin.admin.dto.login.LoginDTO;
import scut.yulin.admin.dto.traveler.InsertTravelerDTO;
import scut.yulin.admin.dto.traveler.ModifyTravelerDTO;
import scut.yulin.admin.dto.traveler.QueryTravelerDTO;
import scut.yulin.mbg.model.Resource;
import scut.yulin.mbg.model.Traveler;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description TODO
 **/
public interface TravelerAdminService {

  public int addNewTraveler(InsertTravelerDTO dto);

  public List<Traveler> getTravelerList(QueryTravelerDTO dto);

  public Traveler getTravelerByUUID(QueryTravelerDTO dto);

  public Traveler getTravelerByName(QueryTravelerDTO dto);

  public int deleteTraveler(QueryTravelerDTO dto);

  public int modifyTraveler(ModifyTravelerDTO dto);

  public Traveler getCurrentTraveler();

  public String login(LoginDTO dto);

  //TODO: register

  /**
   * 获取用户信息
   */
  UserDetails loadUserByUsername(String username);

  List<Resource> getResourceList(String hrUuid);


}
