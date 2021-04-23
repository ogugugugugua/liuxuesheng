package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.Destination;
import scut.yulin.trip.model.DestinationExample;

@Repository
@Mapper
public interface DestinationDao {
    long countByExample(DestinationExample example);

    int deleteByExample(DestinationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Destination record);

    int insertSelective(Destination record);

    List<Destination> selectByExample(DestinationExample example);

    Destination selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Destination record, @Param("example") DestinationExample example);

    int updateByExample(@Param("record") Destination record, @Param("example") DestinationExample example);

    int updateByPrimaryKeySelective(Destination record);

    int updateByPrimaryKey(Destination record);
}