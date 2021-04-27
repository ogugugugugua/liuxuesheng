package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.destination.InsertDestinationDTO;
import scut.yulin.trip.dto.destination.ModifyDestinationDTO;
import scut.yulin.trip.dto.destination.QueryDestinationDTO;
import scut.yulin.trip.model.Destination;

/**
 * @Date 2021/4/23
 * @Author xieyulin
 * @Description TODO
 **/
public interface DestinationService extends ScheduleService{

  public List<Destination> getDestinationList(QueryDestinationDTO queryDestinationDTO);

  public Destination getDestinationByUUID(QueryDestinationDTO queryDestinationDTO, Boolean getFullInformation);

  public int addDestination(InsertDestinationDTO insertDestinationDTO);

  public int deleteDestination(QueryDestinationDTO queryDestinationDTO);

  public int modifyDestination(ModifyDestinationDTO modifyDestinationDTO);
}
