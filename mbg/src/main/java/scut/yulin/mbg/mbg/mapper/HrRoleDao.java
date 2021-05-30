package scut.yulin.mbg.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.mbg.model.HrRole;
import scut.yulin.mbg.model.HrRoleExample;

@Repository
@Mapper
public interface HrRoleDao {
    long countByExample(HrRoleExample example);

    int deleteByExample(HrRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    List<HrRole> selectByExample(HrRoleExample example);

    HrRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByExample(@Param("record") HrRole record, @Param("example") HrRoleExample example);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);
}