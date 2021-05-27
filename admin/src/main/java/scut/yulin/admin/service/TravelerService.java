package scut.yulin.admin.service;

import java.util.List;
import scut.yulin.admin.dto.traveler.InsertTravelerDTO;
import scut.yulin.admin.dto.traveler.ModifyTravelerDTO;
import scut.yulin.admin.dto.traveler.QueryTravelerDTO;
import scut.yulin.admin.model.Traveler;

/**
 * @Date 2021/5/27
 * @Author xieyulin
 * @Description TODO
 **/
public interface TravelerService {

  public int addNewTraveler(InsertTravelerDTO dto);

  public List<Traveler> getTravelerList(QueryTravelerDTO dto);

  public Traveler getTravelerByUUID(QueryTravelerDTO dto);

  public Traveler getTravelerByName(QueryTravelerDTO dto);

  public int deleteTraveler(QueryTravelerDTO dto);

  public int modifyTraveler(ModifyTravelerDTO dto);
}
