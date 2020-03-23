package com.xuersheng.myProject.security;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.UserMapper;
import com.xuersheng.myProject.model.Role;
import com.xuersheng.myProject.model.User;
import com.xuersheng.myProject.model.example.UserExample;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    UserMapper userMapper;


    @Override
    @DataSource("default")
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUsernameEqualTo(username)
                .andDeletedEqualTo(false);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            throw new UsernameNotFoundException(username);
        }
        Long id = users.get(0).getId();
        User user = userMapper.selectUserDetailById(id);
        List<Role> roles = user.getRoles();
        List<Long> roleIds = roles.stream().map(Role::getId).collect(Collectors.toList());
        user.setRoleIds(roleIds);
        List<GrantedAuthority> authorities = new ArrayList<>(roles.size());
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getPermission()));
        }
        return new UserDetailsImpl(user, authorities);
    }


}
