package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.bed.InsertBedDTO;
import scut.yulin.trip.dto.bed.ModifyBedDTO;
import scut.yulin.trip.dto.bed.QueryBedDTO;
import scut.yulin.trip.model.Bed;

/**
 * @Date 2021/4/25
 * @Author xieyulin
 * @Description TODO
 **/
public interface BedService {
  public Bed getBedByUUID(QueryBedDTO queryBedDTO);

  public List<Bed> getBedList(QueryBedDTO queryBedDTO);

  public List<Bed> getBedListByRoomUUID(QueryBedDTO queryBedDTO);

  public int addNewBed(InsertBedDTO insertBedDTO);

  public int deleteBed(QueryBedDTO queryBedDTO);

  public int modifyBed(ModifyBedDTO modifyBedDTO);
}
