package scut.yulin.admin.mbg.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import scut.yulin.admin.model.ResourceRole;
import scut.yulin.admin.model.ResourceRoleExample;

@Repository
@Mapper
public interface ResourceRoleDao {
    long countByExample(ResourceRoleExample example);

    int deleteByExample(ResourceRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ResourceRole record);

    int insertSelective(ResourceRole record);

    List<ResourceRole> selectByExample(ResourceRoleExample example);

    ResourceRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ResourceRole record, @Param("example") ResourceRoleExample example);

    int updateByExample(@Param("record") ResourceRole record, @Param("example") ResourceRoleExample example);

    int updateByPrimaryKeySelective(ResourceRole record);

    int updateByPrimaryKey(ResourceRole record);
}