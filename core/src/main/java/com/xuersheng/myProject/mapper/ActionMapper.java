package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.Action;
import com.xuersheng.myProject.model.example.ActionExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActionMapper {
    long countByExample(ActionExample example);

    int deleteByExample(ActionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Action record);

    int insertSelective(Action record);

    List<Action> selectByExample(ActionExample example);

    Action selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Action record, @Param("example") ActionExample example);

    int updateByExample(@Param("record") Action record, @Param("example") ActionExample example);

    int updateByPrimaryKeySelective(Action record);

    int updateByPrimaryKey(Action record);
}