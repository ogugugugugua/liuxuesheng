package scut.yulin.trip.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.trip.dto.transportationType.QueryTransportationTypeDTO;
import scut.yulin.trip.mbg.mapper.TransportationTypeDao;
import scut.yulin.trip.model.TransportationType;
import scut.yulin.trip.model.TransportationTypeExample;
import scut.yulin.trip.service.TransportationTypeService;

@Service
public class TransportationTypeServiceImpl implements TransportationTypeService {

  @Autowired
  TransportationTypeDao transportationTypeDao;

  @Override
  public TransportationType getTransportationTypeByUUID(
      QueryTransportationTypeDTO queryTransportationTypeDTO) {
    TransportationTypeExample example = new TransportationTypeExample();
    String uuid = queryTransportationTypeDTO.getUuid();
    example.createCriteria()
        .andUuidEqualTo(uuid)
        .andDeletedEqualTo(CommonConstant.NOT_DELETED);
    List<TransportationType> transportationTypes = transportationTypeDao.selectByExample(example);
    if (transportationTypes.size() > 0) {
      return transportationTypes.get(0);
    }
    return null;
  }

  public 
}
