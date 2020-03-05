package com.xuersheng.myProject.model;

import com.xuersheng.myProject.model.base.BaseUser;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class User extends BaseUser {

    private List<Role> roles;

    private UserSetting userSetting;

    private List<Long> roleIds;
}