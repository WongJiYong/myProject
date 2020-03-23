package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.UserSetting;
import com.xuersheng.myProject.model.example.UserSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSettingMapper {

    long countByExample(UserSettingExample example);

    int deleteByExample(UserSettingExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(UserSetting record);

    int insertSelective(UserSetting record);

    List<UserSetting> selectByExample(UserSettingExample example);

    UserSetting selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") UserSetting record, @Param("example") UserSettingExample example);

    int updateByExample(@Param("record") UserSetting record, @Param("example") UserSettingExample example);

    int updateByPrimaryKeySelective(UserSetting record);

    int updateByPrimaryKey(UserSetting record);

}
