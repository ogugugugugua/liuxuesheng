package scut.yulin.mbg.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.mbg.model.Traveler;
import scut.yulin.mbg.model.TravelerExample;

@Repository
@Mapper
public interface TravelerDao {

  long countByExample(TravelerExample example);

  int deleteByExample(TravelerExample example);

  int deleteByPrimaryKey(Long id);

  int insert(Traveler record);

  int insertSelective(Traveler record);

  List<Traveler> selectByExample(TravelerExample example);

  Traveler selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") Traveler record,
      @Param("example") TravelerExample example);

  int updateByExample(@Param("record") Traveler record, @Param("example") TravelerExample example);

  int updateByPrimaryKeySelective(Traveler record);

  int updateByPrimaryKey(Traveler record);
}