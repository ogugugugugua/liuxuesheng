package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.transportationType.InsertTransportationTypeDTO;
import scut.yulin.trip.dto.transportationType.ModifyTransportationTypeDTO;
import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.model.TransportationType;

public interface TransportationTypeService {

  public TransportationType getTransportationTypeByUUID(
      QueryTransportationTypeDTO queryTransportationTypeDTO);

  public int addNewTrasportationType(
      InsertTransportationTypeDTO insertTransportationTypeDTO);

  public List<TransportationType> getTransportationTypeList(
      QueryTransportationTypeDTO queryTransportationTypeDTO);

  public int deleteTrasportationType(
      QueryTransportationTypeDTO queryTransportationTypeDTO);

  public int modifyTrasportationType(
      ModifyTransportationTypeDTO modifyTransportationTypeDTO);
}
