package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.UsersRoles;
import com.xuersheng.myProject.model.example.UsersRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersRolesMapper {

    long countByExample(UsersRolesExample example);

    int deleteByExample(UsersRolesExample example);

    int deleteByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int insert(UsersRoles record);

    int insertSelective(UsersRoles record);

    List<UsersRoles> selectByExample(UsersRolesExample example);

    UsersRoles selectByPrimaryKey(@Param("userId") Long userId, @Param("roleId") Long roleId);

    int updateByExampleSelective(@Param("record") UsersRoles record, @Param("example") UsersRolesExample example);

    int updateByExample(@Param("record") UsersRoles record, @Param("example") UsersRolesExample example);

    int updateByPrimaryKeySelective(UsersRoles record);

    int updateByPrimaryKey(UsersRoles record);
}
