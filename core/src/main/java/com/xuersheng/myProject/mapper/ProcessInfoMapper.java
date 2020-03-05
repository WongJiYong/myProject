package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.ProcessInfo;
import com.xuersheng.myProject.model.example.ProcessInfoExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProcessInfoMapper {
    long countByExample(ProcessInfoExample example);

    int deleteByExample(ProcessInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProcessInfo record);

    int insertSelective(ProcessInfo record);

    List<ProcessInfo> selectByExample(ProcessInfoExample example);

    ProcessInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProcessInfo record, @Param("example") ProcessInfoExample example);

    int updateByExample(@Param("record") ProcessInfo record, @Param("example") ProcessInfoExample example);

    int updateByPrimaryKeySelective(ProcessInfo record);

    int updateByPrimaryKey(ProcessInfo record);
}