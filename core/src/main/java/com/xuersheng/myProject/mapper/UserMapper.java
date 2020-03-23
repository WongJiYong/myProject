package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.User;
import com.xuersheng.myProject.model.example.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.xuersheng.myProject.model.dto.UserDto;

public interface UserMapper {

    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectUserDetailById(Long id);

    List<User> selectUserByDto(UserDto userDto);
}
