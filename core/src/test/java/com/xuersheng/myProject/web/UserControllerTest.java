package com.xuersheng.myProject.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuersheng.myProject.mapper.RoleMapper;
import com.xuersheng.myProject.mapper.UserMapper;
import com.xuersheng.myProject.mapper.UsersRolesMapper;
import com.xuersheng.myProject.model.Role;
import com.xuersheng.myProject.model.User;
import com.xuersheng.myProject.model.UsersRoles;
import com.xuersheng.myProject.model.dto.PageDto;
import com.xuersheng.myProject.model.dto.UserDto;
import com.xuersheng.myProject.model.dto.UserRoleDto;
import com.xuersheng.myProject.model.dto.UserSettingDto;
import com.xuersheng.myProject.model.example.UserExample;
import com.xuersheng.myProject.util.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@Rollback
@Transactional(rollbackFor = Exception.class)
public class UserControllerTest extends BaseControllerTest {

    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    UsersRolesMapper usersRolesMapper;

    static class URL {
        static String info = "/user/info";
        static String lock = "/user/lock";
        static String setting = "/user/setting/modify";
        static String query = "/user/query";
        static String add = "/user/add";
        static String modify = "/user/modify";
        static String remove = "/user/remove";
        static String addRole = "/user/role/add";
        static String removeRole = "/user/role/remove";
    }

    @Test
    @WithUserDetails("admin")
    public void IntegratedTest() throws Exception {

        String[] fields = {
                "email",
                "username",
                "password",
                "phone",
                "sex",
                "enabled",
                "locked",
                "version",
        };
        UserDto userDto = TestUtil.randomObject(UserDto.class, fields);
        addUser(userDto);
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(userDto.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        assert users.size() == 1;
        User user = users.get(0);
        userDto.setId(user.getId());
        List<Role> roles = roleMapper.selectByExample(null);
        assert roles.size() > 0;
        Long roleId = roles.get(0).getId();
        //添加角色
        UserRoleDto userRoleDto = new UserRoleDto();
        userRoleDto.setUserId(user.getId());
        userRoleDto.setRoleId(roleId);
        addRole(userRoleDto);
        UsersRoles usersRoles = usersRolesMapper.selectByPrimaryKey(user.getId(), roleId);
        assert usersRoles != null && !usersRoles.getDeleted();
        log.info("添加角色 success");
        //删除角色
        removeRole(userRoleDto);
        usersRoles = usersRolesMapper.selectByPrimaryKey(user.getId(), roleId);
        assert usersRoles != null && usersRoles.getDeleted();
        log.info("删除角色 success");

        //锁用户
        lockedUser(userDto);
        User user1 = userMapper.selectByPrimaryKey(userDto.getId());
        assert user1 != null && user1.getLocked();
        log.info("锁用户 success");
        //修改用户
        UserDto modifyUserDto = TestUtil.randomObject(UserDto.class, fields);
        modifyUserDto.setEnabled(!user1.getEnabled());
        modifyUserDto.setLocked(!user1.getLocked());
        modifyUserDto.setId(userDto.getId());
        modifyUser(modifyUserDto);
        User user2 = userMapper.selectByPrimaryKey(userDto.getId());
        assert TestUtil.equalsObjs(user2, modifyUserDto, fields);
        log.info("修改用户 success");

        //删除用户
        modifyUserDto.setId(user2.getId());
        modifyUserDto.setVersion(user2.getVersion());
        removeUser(modifyUserDto);
        User user3 = userMapper.selectByPrimaryKey(userDto.getId());
        assert user3 != null && user3.getDeleted();
        log.info("删除用户 success");
    }

    @Test
    @WithUserDetails("admin")
    public void userDetailInfo() throws Exception {
        MvcResult mvcResult = mvc.perform(
                get(URL.info).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andReturn();
        String contentAsString = mvcResult.getResponse().getContentAsString();
        JsonNode jsonNode = new ObjectMapper().readTree(contentAsString);
        assert "admin".equals(jsonNode.get("data").get("username").asText());
    }


    private void lockedUser(UserDto dto) throws Exception {
        httpPost(URL.lock, dto);
    }


    @Test
    @WithUserDetails("admin")
    public void modifySetting() throws Exception {
        UserSettingDto dto = new UserSettingDto();
        dto.setRoleId(null);
        dto.setPageSize(30);
        httpPost(URL.setting, dto);
    }


    @Test
    @WithUserDetails("admin")
    public void queryUsers() throws Exception {
        UserDto dto = new UserDto();
        PageDto pageDto = new PageDto();
        dto.setPage(pageDto);
        String content = httpGet(URL.query, dto);
        JsonNode jsonNode = new ObjectMapper().readTree(content);
        assert jsonNode.get("data").get("total").asInt() > 0;
    }


    private void addUser(UserDto dto) throws Exception {
        httpPost(URL.add, dto);
    }


    private void modifyUser(UserDto dto) throws Exception {
        httpPost(URL.modify, dto);
    }


    private void removeUser(UserDto dto) throws Exception {
        httpPost(URL.remove, dto);
    }


    private void addRole(UserRoleDto dto) throws Exception {
        httpPost(URL.addRole, dto);
    }

    private void removeRole(UserRoleDto dto) throws Exception {
        httpPost(URL.removeRole, dto);
    }
}