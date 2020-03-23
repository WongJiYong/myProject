package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table users_roles
 */
@Setter
@Getter
public class UsersRoles {

    /**
     * 用户ID
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 角色ID
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     * 逻辑删除位
     *
     * @mbg.generated
     */
    private Boolean deleted;
}
