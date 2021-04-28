package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.Trip;
import scut.yulin.trip.model.TripExample;

@Repository
@Mapper
public interface TripDao {
    long countByExample(TripExample example);

    int deleteByExample(TripExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Trip record);

    int insertSelective(Trip record);

    List<Trip> selectByExample(TripExample example);

    Trip selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Trip record, @Param("example") TripExample example);

    int updateByExample(@Param("record") Trip record, @Param("example") TripExample example);

    int updateByPrimaryKeySelective(Trip record);

    int updateByPrimaryKey(Trip record);
}