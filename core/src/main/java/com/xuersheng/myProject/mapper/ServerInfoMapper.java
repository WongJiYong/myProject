package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.ServerInfo;
import com.xuersheng.myProject.model.example.ServerInfoExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServerInfoMapper {
    long countByExample(ServerInfoExample example);

    int deleteByExample(ServerInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ServerInfo record);

    int insertSelective(ServerInfo record);

    List<ServerInfo> selectByExample(ServerInfoExample example);

    ServerInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ServerInfo record, @Param("example") ServerInfoExample example);

    int updateByExample(@Param("record") ServerInfo record, @Param("example") ServerInfoExample example);

    int updateByPrimaryKeySelective(ServerInfo record);

    int updateByPrimaryKey(ServerInfo record);
}