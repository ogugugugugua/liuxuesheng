package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.HoteluuidRoomuuid;
import scut.yulin.trip.model.HoteluuidRoomuuidExample;

@Repository
@Mapper
public interface HoteluuidRoomuuidDao {
    long countByExample(HoteluuidRoomuuidExample example);

    int deleteByExample(HoteluuidRoomuuidExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HoteluuidRoomuuid record);

    int insertSelective(HoteluuidRoomuuid record);

    List<HoteluuidRoomuuid> selectByExample(HoteluuidRoomuuidExample example);

    HoteluuidRoomuuid selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HoteluuidRoomuuid record, @Param("example") HoteluuidRoomuuidExample example);

    int updateByExample(@Param("record") HoteluuidRoomuuid record, @Param("example") HoteluuidRoomuuidExample example);

    int updateByPrimaryKeySelective(HoteluuidRoomuuid record);

    int updateByPrimaryKey(HoteluuidRoomuuid record);
}