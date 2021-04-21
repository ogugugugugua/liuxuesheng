package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.Transportation;
import scut.yulin.trip.model.TransportationExample;

@Repository
@Mapper
public interface TransportationDao {
    long countByExample(TransportationExample example);

    int deleteByExample(TransportationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Transportation record);

    int insertSelective(Transportation record);

    List<Transportation> selectByExample(TransportationExample example);

    Transportation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Transportation record, @Param("example") TransportationExample example);

    int updateByExample(@Param("record") Transportation record, @Param("example") TransportationExample example);

    int updateByPrimaryKeySelective(Transportation record);

    int updateByPrimaryKey(Transportation record);
}