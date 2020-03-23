package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.UserAvatar;
import com.xuersheng.myProject.model.example.UserAvatarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAvatarMapper {

    long countByExample(UserAvatarExample example);

    int deleteByExample(UserAvatarExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAvatar record);

    int insertSelective(UserAvatar record);

    List<UserAvatar> selectByExample(UserAvatarExample example);

    UserAvatar selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAvatar record, @Param("example") UserAvatarExample example);

    int updateByExample(@Param("record") UserAvatar record, @Param("example") UserAvatarExample example);

    int updateByPrimaryKeySelective(UserAvatar record);

    int updateByPrimaryKey(UserAvatar record);
}
