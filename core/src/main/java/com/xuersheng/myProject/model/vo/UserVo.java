package com.xuersheng.myProject.model.vo;

import com.xuersheng.myProject.model.UserSetting;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class UserVo {

    private Long id;

    private String email;

    private String username;

    private String phone;

    private Long jobId;

    private Date createTime;

    private String nickName;

    private String sex;

    private Boolean locked;

    private Boolean enabled;

    private List<Long> roleIds;

    private List<RoleVo> roles;

    private UserSetting userSetting;
}
