package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.EmailConfig;
import com.xuersheng.myProject.model.example.EmailConfigExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailConfigMapper {
    long countByExample(EmailConfigExample example);

    int deleteByExample(EmailConfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EmailConfig record);

    int insertSelective(EmailConfig record);

    List<EmailConfig> selectByExample(EmailConfigExample example);

    EmailConfig selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EmailConfig record, @Param("example") EmailConfigExample example);

    int updateByExample(@Param("record") EmailConfig record, @Param("example") EmailConfigExample example);

    int updateByPrimaryKeySelective(EmailConfig record);

    int updateByPrimaryKey(EmailConfig record);
}