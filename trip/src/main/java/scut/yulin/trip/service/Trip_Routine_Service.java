package scut.yulin.trip.service;

import java.util.List;
import scut.yulin.trip.dto.trip_routine.Insert_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Modify_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Query_Trip_Routine_DTO;
import scut.yulin.trip.dto.trip_routine.Result_Trip_Routine_DTO;

/**
 * @Date 2021/4/28
 * @Author xieyulin
 * @Description TODO
 **/
public interface Trip_Routine_Service {

  public List<Result_Trip_Routine_DTO> getRoutineListByTripUUID(Query_Trip_Routine_DTO query_trip_routine_dto, Boolean getFullInformation);

  public int addNewTripRoutineRelationAsSerialN(Insert_Trip_Routine_DTO insert_trip_routine_dto);

  public int deleteTripRoutineRelation(Query_Trip_Routine_DTO query_trip_routine_dto);

  public int modifyTripRoutineRelation(Modify_Trip_Routine_DTO modify_trip_routine_dto);


}
