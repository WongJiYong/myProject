package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.RolesAction;
import com.xuersheng.myProject.model.example.RolesActionExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesActionMapper {
    long countByExample(RolesActionExample example);

    int deleteByExample(RolesActionExample example);

    int deleteByPrimaryKey(@Param("actionId") Long actionId, @Param("roleId") Long roleId);

    int insert(RolesAction record);

    int insertSelective(RolesAction record);

    List<RolesAction> selectByExample(RolesActionExample example);

    RolesAction selectByPrimaryKey(@Param("actionId") Long actionId, @Param("roleId") Long roleId);

    int updateByExampleSelective(@Param("record") RolesAction record, @Param("example") RolesActionExample example);

    int updateByExample(@Param("record") RolesAction record, @Param("example") RolesActionExample example);

    int updateByPrimaryKeySelective(RolesAction record);

    int updateByPrimaryKey(RolesAction record);
}