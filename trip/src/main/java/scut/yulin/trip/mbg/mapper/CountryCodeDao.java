package scut.yulin.trip.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.trip.model.CountryCode;
import scut.yulin.trip.model.CountryCodeExample;

@Repository
@Mapper
public interface CountryCodeDao {
    long countByExample(CountryCodeExample example);

    int deleteByExample(CountryCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CountryCode record);

    int insertSelective(CountryCode record);

    List<CountryCode> selectByExample(CountryCodeExample example);

    CountryCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CountryCode record, @Param("example") CountryCodeExample example);

    int updateByExample(@Param("record") CountryCode record, @Param("example") CountryCodeExample example);

    int updateByPrimaryKeySelective(CountryCode record);

    int updateByPrimaryKey(CountryCode record);
}