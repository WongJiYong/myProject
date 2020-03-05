package com.xuersheng.myProject.security;

import com.xuersheng.myProject.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private User user;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(User user, Collection<? extends GrantedAuthority> authorities) {
        Assert.notNull(user, "用户不能为null");
        Assert.notNull(authorities, "权限不能为null");
        Assert.notEmpty(authorities, "权限不能为empty");
        this.user = user;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !user.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }

    public User getUser() {
        return user;
    }
}
