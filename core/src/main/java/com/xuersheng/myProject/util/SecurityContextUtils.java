package com.xuersheng.myProject.util;

import com.xuersheng.myProject.security.UserDetailsImpl;
import com.xuersheng.myProject.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SecurityContextUtils {

    public static User getUser(){
        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal()).getUser();
    }
    public static List<String> getRoles(){
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
    }
}