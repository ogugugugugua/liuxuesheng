package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.Routine;
import scut.yulin.trip.model.RoutineExample;

@Repository
@Mapper
public interface RoutineDao {
    long countByExample(RoutineExample example);

    int deleteByExample(RoutineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Routine record);

    int insertSelective(Routine record);

    List<Routine> selectByExample(RoutineExample example);

    Routine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Routine record, @Param("example") RoutineExample example);

    int updateByExample(@Param("record") Routine record, @Param("example") RoutineExample example);

    int updateByPrimaryKeySelective(Routine record);

    int updateByPrimaryKey(Routine record);
}