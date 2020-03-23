package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * table user
 */
@Setter
@Getter
public class User {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 头像
     *
     * @mbg.generated
     */
    private Long avatarId;

    /**
     * 邮箱
     *
     * @mbg.generated
     */
    private String email;

    /**
     * 密码
     *
     * @mbg.generated
     */
    private String password;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    private String username;

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    private Long deptId;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    private String phone;

    /**
     * 岗位名称
     *
     * @mbg.generated
     */
    private Long jobId;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 最后修改密码的日期
     *
     * @mbg.generated
     */
    private Date lastPasswordResetTime;

    /**
     * @mbg.generated
     */
    private String nickName;

    /**
     * @mbg.generated
     */
    private String sex;

    /**
     * 逻辑删除位
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     * 是否锁定
     *
     * @mbg.generated
     */
    private Boolean locked;

    /**
     * 账号是否可用
     *
     * @mbg.generated
     */
    private Boolean enabled;

    /**
     * 版本号
     *
     * @mbg.generated
     */
    private Integer version;

    private List<Role> roles;

    private UserSetting userSetting;

    private List<Long> roleIds;
}
