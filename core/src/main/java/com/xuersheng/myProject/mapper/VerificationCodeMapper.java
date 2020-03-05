package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.VerificationCode;
import com.xuersheng.myProject.model.example.VerificationCodeExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VerificationCodeMapper {
    long countByExample(VerificationCodeExample example);

    int deleteByExample(VerificationCodeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VerificationCode record);

    int insertSelective(VerificationCode record);

    List<VerificationCode> selectByExample(VerificationCodeExample example);

    VerificationCode selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VerificationCode record, @Param("example") VerificationCodeExample example);

    int updateByExample(@Param("record") VerificationCode record, @Param("example") VerificationCodeExample example);

    int updateByPrimaryKeySelective(VerificationCode record);

    int updateByPrimaryKey(VerificationCode record);
}