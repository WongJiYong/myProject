package com.xuersheng.myProject.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.UserMapper;
import com.xuersheng.myProject.mapper.UserSettingMapper;
import com.xuersheng.myProject.mapper.UsersRolesMapper;
import com.xuersheng.myProject.mapper.cus.UserCusMapper;
import com.xuersheng.myProject.model.User;
import com.xuersheng.myProject.model.UserSetting;
import com.xuersheng.myProject.model.UsersRoles;
import com.xuersheng.myProject.model.dto.UserDto;
import com.xuersheng.myProject.model.dto.UserRoleDto;
import com.xuersheng.myProject.model.dto.UserSettingDto;
import com.xuersheng.myProject.model.example.UserExample;
import com.xuersheng.myProject.model.example.UsersRolesExample;
import com.xuersheng.myProject.model.vo.PageVo;
import com.xuersheng.myProject.model.vo.UserVo;
import com.xuersheng.myProject.util.BeanUtils;
import com.xuersheng.myProject.util.PageBuilder;
import com.xuersheng.myProject.util.SecurityContextUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@DataSource("default")
public class UserServices {

    @Resource
    UserMapper userMapper;

    @Resource
    UserCusMapper userCusMapper;

    @Resource
    UsersRolesMapper usersRolesMapper;

    @Resource
    UserSettingMapper userSettingMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public PageVo queryUsers(UserDto roleDto) {
        PageHelper.startPage(
                roleDto.getPage().getCurrentPage(),
                roleDto.getPage().getPageSize());
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        String username = roleDto.getUsername();
        if (StringUtils.hasText(username)) {
            criteria.andUsernameEqualTo(username);
        }
        String email = roleDto.getEmail();
        if (StringUtils.hasText(email)) {
            criteria.andEmailEqualTo(email);
        }
        Boolean locked = roleDto.getLocked();
        if (locked != null) {
            criteria.andLockedEqualTo(locked);
        }
        Boolean enabled = roleDto.getEnabled();
        if (enabled != null) {
            criteria.andEnabledEqualTo(enabled);
        }
        List<User> users = userMapper.selectByExample(userExample);
        List<UserVo> userVos = BeanUtils.copyListDeeply(users, UserVo.class);
        return PageBuilder.builder(userVos, (Page) users);
    }

    @Transactional
    public boolean modifySetting(UserSettingDto dto) {
        UserSetting userSetting = new UserSetting();
        BeanUtils.copyPropertiesDeeply(dto, userSetting);
        return 1 == userSettingMapper.updateByPrimaryKeySelective(userSetting);
    }

    @Transactional
    public boolean addUser(UserDto roleDto) {
        User role = new User();
        role.setId(null);
        if (!StringUtils.isEmpty(roleDto.getPassword())) {
            roleDto.setPassword(passwordEncoder.encode(roleDto.getPassword()));
        }
        role.setCreateTime(new Date());
        BeanUtils.copyPropertiesDeeply(roleDto, role);
        return 1 == userMapper.insert(role);
    }

    @Transactional
    public boolean modifyUser(UserDto roleDto) {
        User role = new User();
        BeanUtils.copyPropertiesDeeply(roleDto, role);
        return 1 == userMapper.updateByPrimaryKeySelective(role);
    }

    @Transactional
    public boolean removeUser(UserDto roleDto) {
        return 1 == userMapper.deleteByPrimaryKey(roleDto.getId());
    }

    @Transactional
    public boolean addRole(UserRoleDto dto) {
        UsersRoles usersRoles = new UsersRoles();
        BeanUtils.copyPropertiesDeeply(dto, usersRoles);
        usersRoles.setDeleted(true);
        return saveOrUpdateUserRole(usersRoles);
    }

    @Transactional
    public boolean removeRole(UserRoleDto dto) {
        UsersRoles usersRoles = new UsersRoles();
        BeanUtils.copyPropertiesDeeply(dto, usersRoles);
        usersRoles.setDeleted(false);
        return saveOrUpdateUserRole(usersRoles);
    }

    @DataSource("default")
    public UserVo userDetailInfo() {
        Long id = SecurityContextUtils.getUser().getId();
        User user = userCusMapper.selectUserDetailById(id);
        UserVo vo = new UserVo();
        BeanUtils.copyPropertiesDeeply(user, vo);
        return vo;
    }

    @DataSource("default")
    public boolean lockUser(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setLocked(true);
        return 1 == userMapper.updateByPrimaryKeySelective(user);
    }

    @DataSource("default")
    public List<Long> queryUserRoles(UserDto dto) {
        UsersRolesExample usersRolesExample = new UsersRolesExample();
        usersRolesExample.createCriteria()
                .andUserIdEqualTo(dto.getId());
        List<UsersRoles> usersRoles = usersRolesMapper.selectByExample(usersRolesExample);
        return usersRoles.stream().map(UsersRoles::getRoleId).collect(Collectors.toList());
    }

    private boolean saveOrUpdateUserRole(UsersRoles usersRoles) {
        UsersRoles userRole = usersRolesMapper.selectByPrimaryKey(usersRoles.getUserId(), usersRoles.getRoleId());
        if (userRole == null) {
            return 1 == usersRolesMapper.insert(usersRoles);
        } else {
            return 1 == usersRolesMapper.updateByPrimaryKeySelective(usersRoles);
        }
    }
}
