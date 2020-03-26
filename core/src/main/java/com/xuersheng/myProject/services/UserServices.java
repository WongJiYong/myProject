package com.xuersheng.myProject.services;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.RoleMapper;
import com.xuersheng.myProject.mapper.UserMapper;
import com.xuersheng.myProject.mapper.UserSettingMapper;
import com.xuersheng.myProject.mapper.UsersRolesMapper;
import com.xuersheng.myProject.model.Role;
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
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@DataSource("default")
@Transactional
public class UserServices {

    @Resource
    UserMapper userMapper;

    @Resource
    RoleMapper roleMapper;

    @Resource
    UsersRolesMapper usersRolesMapper;

    @Resource
    UserSettingMapper userSettingMapper;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public PageVo<?> queryUsers(UserDto roleDto) {
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
        return PageBuilder.builder(userVos, (Page<?>) users);
    }

    public boolean modifySetting(UserSettingDto dto) {
        UserSetting userSetting = new UserSetting();
        BeanUtils.copyPropertiesDeeply(dto, userSetting);
        //获取登录用户的id
        Long id = SecurityContextUtils.getUser().getId();
        //check roleId
        Long roleId = dto.getRoleId();
        if (roleId != null) {
            UsersRolesExample usersRolesExample = new UsersRolesExample();
            usersRolesExample.createCriteria()
                    .andRoleIdEqualTo(roleId);
            List<UsersRoles> usersRoles = usersRolesMapper.selectByExample(usersRolesExample);
            if (usersRoles.size() != 1) {
                return false;
            }
        }
        userSetting.setUserId(id);
        return 1 == userSettingMapper.updateByPrimaryKeySelective(userSetting);
    }

    public boolean addUser(UserDto roleDto) {
        User role = new User();
        role.setId(null);
        if (!StringUtils.isEmpty(roleDto.getPassword())) {
            roleDto.setPassword(passwordEncoder.encode(roleDto.getPassword()));
        }
        role.setCreateTime(new Date());
        role.setDeleted(false);
        BeanUtils.copyPropertiesDeeply(roleDto, role);
        Assert.isTrue(1 == userMapper.insert(role), "添加用户失败");
        UserSetting userSetting = new UserSetting();
        userSetting.setDeleted(false);
        userSetting.setUserId(role.getId());
        Assert.isTrue(1 == userSettingMapper.insert(userSetting), "添加配置错误");
        return true;
    }

    public boolean modifyUser(UserDto roleDto) {
        User role = new User();
        BeanUtils.copyPropertiesDeeply(roleDto, role);
        return 1 == userMapper.updateByPrimaryKeySelective(role);
    }

    public boolean enabledUser(UserDto dto) {
        User user = new User();
        user.setEnabled(dto.getEnabled());
        user.setVersion(dto.getVersion() + 1);
        UserExample example = new UserExample();
        example.createCriteria()
                .andIdEqualTo(dto.getId())
                .andVersionEqualTo(dto.getVersion());
        return 1 == userMapper.updateByExampleSelective(user, example);
    }

    public boolean addRole(UserRoleDto dto) {
        UsersRoles usersRoles = new UsersRoles();
        BeanUtils.copyPropertiesDeeply(dto, usersRoles);
        usersRoles.setDeleted(false);
        return saveOrUpdateUserRole(usersRoles);
    }

    public boolean removeRole(UserRoleDto dto) {
        UsersRoles usersRoles = new UsersRoles();
        BeanUtils.copyPropertiesDeeply(dto, usersRoles);
        usersRoles.setDeleted(true);
        return saveOrUpdateUserRole(usersRoles);
    }

    public UserVo userDetailInfo() {
        Long id = SecurityContextUtils.getUser().getId();
        User user = userMapper.selectUserDetailById(id);
        UserVo vo = new UserVo();
        BeanUtils.copyPropertiesDeeply(user, vo);
        return vo;
    }


    public boolean lockUser(UserDto dto) {
        User user = new User();
        user.setLocked(dto.getLocked());
        user.setVersion(dto.getVersion() + 1);
        UserExample example = new UserExample();
        example.createCriteria()
                .andIdEqualTo(dto.getId())
                .andVersionEqualTo(dto.getVersion());
        return 1 == userMapper.updateByExampleSelective(user, example);
    }


    public List<Long> queryUserRoles(UserDto dto) {
        UsersRolesExample usersRolesExample = new UsersRolesExample();
        usersRolesExample.createCriteria()
                .andUserIdEqualTo(dto.getId())
                .andDeletedEqualTo(false);
        List<UsersRoles> usersRoles = usersRolesMapper.selectByExample(usersRolesExample);
        return usersRoles.stream().map(UsersRoles::getRoleId).collect(Collectors.toList());
    }

    private boolean saveOrUpdateUserRole(UsersRoles usersRoles) {
        //检查角色是否存在
        Long roleId = usersRoles.getRoleId();
        Role role = roleMapper.selectByPrimaryKey(roleId);
        if (role == null) {
            return false;
        }
        UsersRoles userRole = usersRolesMapper.selectByPrimaryKey(usersRoles.getUserId(), roleId);
        if (userRole == null) {
            return 1 == usersRolesMapper.insert(usersRoles);
        } else {
            return 1 == usersRolesMapper.updateByPrimaryKeySelective(usersRoles);
        }
    }
}
