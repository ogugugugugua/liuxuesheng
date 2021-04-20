package scut.yulin.trip.service;

import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.model.TransportationType;

public interface TransportationTypeService {
  public TransportationType getTransportationTypeByUUID(
      QueryTransportationTypeDTO queryTransportationTypeDTO);
}
