package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.RolesMenus;
import com.xuersheng.myProject.model.example.RolesMenusExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesMenusMapper {
    long countByExample(RolesMenusExample example);

    int deleteByExample(RolesMenusExample example);

    int deleteByPrimaryKey(@Param("menuId") Long menuId, @Param("roleId") Long roleId);

    int insert(RolesMenus record);

    int insertSelective(RolesMenus record);

    List<RolesMenus> selectByExample(RolesMenusExample example);

    RolesMenus selectByPrimaryKey(@Param("menuId") Long menuId, @Param("roleId") Long roleId);

    int updateByExampleSelective(@Param("record") RolesMenus record, @Param("example") RolesMenusExample example);

    int updateByExample(@Param("record") RolesMenus record, @Param("example") RolesMenusExample example);

    int updateByPrimaryKeySelective(RolesMenus record);

    int updateByPrimaryKey(RolesMenus record);
}