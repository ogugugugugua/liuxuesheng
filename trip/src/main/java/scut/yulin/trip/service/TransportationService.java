package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.transportation.InsertTransportationDTO;
import scut.yulin.trip.dto.transportation.ModifyTransportationDTO;
import scut.yulin.trip.dto.transportation.QueryTransportationDTO;
import scut.yulin.trip.model.Transportation;

/**
 * @Date 2021/4/21
 * @Author xieyulin
 * @Description TODO
 **/
public interface TransportationService {

  public Transportation getTransportationByUUID(QueryTransportationDTO queryTransportationDTO);

  public List<Transportation> getTransportationList(QueryTransportationDTO queryTransportationDTO);

  public List<Transportation> getTransportationListByScheduleUUID(QueryTransportationDTO queryTransportationDTO);

  public int addNewTransportation(InsertTransportationDTO insertTransportationDTO);

  public int deleteTransportation(QueryTransportationDTO queryTransportationDTO);

  public int modifyTransportation(ModifyTransportationDTO modifyTransportationDTO);
}
