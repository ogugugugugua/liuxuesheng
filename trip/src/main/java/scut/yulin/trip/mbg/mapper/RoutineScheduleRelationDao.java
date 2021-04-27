package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.RoutineScheduleRelation;
import scut.yulin.trip.model.RoutineScheduleRelationExample;

@Repository
@Mapper
public interface RoutineScheduleRelationDao {
    long countByExample(RoutineScheduleRelationExample example);

    int deleteByExample(RoutineScheduleRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoutineScheduleRelation record);

    int insertSelective(RoutineScheduleRelation record);

    List<RoutineScheduleRelation> selectByExample(RoutineScheduleRelationExample example);

    RoutineScheduleRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoutineScheduleRelation record, @Param("example") RoutineScheduleRelationExample example);

    int updateByExample(@Param("record") RoutineScheduleRelation record, @Param("example") RoutineScheduleRelationExample example);

    int updateByPrimaryKeySelective(RoutineScheduleRelation record);

    int updateByPrimaryKey(RoutineScheduleRelation record);
}