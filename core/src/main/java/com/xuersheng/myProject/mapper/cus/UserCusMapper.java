package com.xuersheng.myProject.mapper.cus;

import com.xuersheng.myProject.model.User;
import com.xuersheng.myProject.model.dto.UserDto;

import java.util.List;

public interface UserCusMapper {

    User selectUserDetailById(Long id);

    List<User> selectUserByDto(UserDto userDto);
}
