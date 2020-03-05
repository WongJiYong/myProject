package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.DictDetail;
import com.xuersheng.myProject.model.example.DictDetailExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictDetailMapper {
    long countByExample(DictDetailExample example);

    int deleteByExample(DictDetailExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DictDetail record);

    int insertSelective(DictDetail record);

    List<DictDetail> selectByExample(DictDetailExample example);

    DictDetail selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DictDetail record, @Param("example") DictDetailExample example);

    int updateByExample(@Param("record") DictDetail record, @Param("example") DictDetailExample example);

    int updateByPrimaryKeySelective(DictDetail record);

    int updateByPrimaryKey(DictDetail record);
}