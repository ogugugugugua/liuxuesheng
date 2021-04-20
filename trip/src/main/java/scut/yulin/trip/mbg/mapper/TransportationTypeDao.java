package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.TransportationType;
import scut.yulin.trip.model.TransportationTypeExample;

@Repository
@Mapper
public interface TransportationTypeDao {
    long countByExample(TransportationTypeExample example);

    int deleteByExample(TransportationTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TransportationType record);

    int insertSelective(TransportationType record);

    List<TransportationType> selectByExample(TransportationTypeExample example);

    TransportationType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TransportationType record, @Param("example") TransportationTypeExample example);

    int updateByExample(@Param("record") TransportationType record, @Param("example") TransportationTypeExample example);

    int updateByPrimaryKeySelective(TransportationType record);

    int updateByPrimaryKey(TransportationType record);
}