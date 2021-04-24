package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.Vehicle;
import scut.yulin.trip.model.VehicleExample;

@Repository
@Mapper
public interface VehicleDao {
    long countByExample(VehicleExample example);

    int deleteByExample(VehicleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Vehicle record);

    int insertSelective(Vehicle record);

    List<Vehicle> selectByExample(VehicleExample example);

    Vehicle selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    int updateByExample(@Param("record") Vehicle record, @Param("example") VehicleExample example);

    int updateByPrimaryKeySelective(Vehicle record);

    int updateByPrimaryKey(Vehicle record);
}