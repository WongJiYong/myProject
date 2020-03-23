package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.RolesDepts;
import com.xuersheng.myProject.model.example.RolesDeptsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesDeptsMapper {

    long countByExample(RolesDeptsExample example);

    int deleteByExample(RolesDeptsExample example);

    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("deptId") Long deptId);

    int insert(RolesDepts record);

    int insertSelective(RolesDepts record);

    List<RolesDepts> selectByExample(RolesDeptsExample example);

    RolesDepts selectByPrimaryKey(@Param("roleId") Long roleId, @Param("deptId") Long deptId);

    int updateByExampleSelective(@Param("record") RolesDepts record, @Param("example") RolesDeptsExample example);

    int updateByExample(@Param("record") RolesDepts record, @Param("example") RolesDeptsExample example);

    int updateByPrimaryKeySelective(RolesDepts record);

    int updateByPrimaryKey(RolesDepts record);
}
