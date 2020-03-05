package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.Dict;
import com.xuersheng.myProject.model.example.DictExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictMapper {
    long countByExample(DictExample example);

    int deleteByExample(DictExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Dict record);

    int insertSelective(Dict record);

    List<Dict> selectByExample(DictExample example);

    Dict selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByExample(@Param("record") Dict record, @Param("example") DictExample example);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);
}