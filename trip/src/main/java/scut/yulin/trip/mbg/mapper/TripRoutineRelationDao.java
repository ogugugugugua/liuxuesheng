package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.TripRoutineRelation;
import scut.yulin.trip.model.TripRoutineRelationExample;

@Repository
@Mapper
public interface TripRoutineRelationDao {
    long countByExample(TripRoutineRelationExample example);

    int deleteByExample(TripRoutineRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TripRoutineRelation record);

    int insertSelective(TripRoutineRelation record);

    List<TripRoutineRelation> selectByExample(TripRoutineRelationExample example);

    TripRoutineRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TripRoutineRelation record, @Param("example") TripRoutineRelationExample example);

    int updateByExample(@Param("record") TripRoutineRelation record, @Param("example") TripRoutineRelationExample example);

    int updateByPrimaryKeySelective(TripRoutineRelation record);

    int updateByPrimaryKey(TripRoutineRelation record);
}