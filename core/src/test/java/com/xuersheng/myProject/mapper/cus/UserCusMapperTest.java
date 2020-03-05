package com.xuersheng.myProject.mapper.cus;

import com.xuersheng.myProject.ApplicationBaseTest;
import com.xuersheng.myProject.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

@Slf4j
public class UserCusMapperTest extends ApplicationBaseTest {

    @Resource
    UserCusMapper userCusMapper;

    @Test
    public void selectUserById() {
        User user = userCusMapper.selectUserDetailById(1L);
        log.info("user: {}", user);
    }
}