package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table user_setting
 */
@Setter
@Getter
public class UserSetting {

    /**
     * 用户id
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 默认角色id
     *
     * @mbg.generated
     */
    private Long roleId;

    /**
     * 默认查询页大小
     *
     * @mbg.generated
     */
    private Integer pageSize;

    /**
     * 逻辑删除位
     *
     * @mbg.generated
     */
    private Boolean deleted;
}
