package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.vehicle.InsertVehicleDTO;
import scut.yulin.trip.dto.vehicle.ModifyVehicleDTO;
import scut.yulin.trip.dto.vehicle.QueryVehicleDTO;
import scut.yulin.trip.model.Vehicle;

/**
 * @Date 2021/4/24
 * @Author xieyulin
 * @Description TODO
 **/
public interface VehicleService {
  public List<Vehicle> getVehicleList(QueryVehicleDTO queryVehicleDTO);

  public Vehicle getVehicleByUUID(QueryVehicleDTO queryVehicleDTO, Boolean getFullInformation);

  public int addVehicle(InsertVehicleDTO insertVehicleDTO);

  public int deleteVehicle(QueryVehicleDTO queryVehicleDTO);

  public int modifyVehicle(ModifyVehicleDTO modifyVehicleDTO);
}
