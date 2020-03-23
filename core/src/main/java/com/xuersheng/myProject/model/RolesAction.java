package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table roles_action
 */
@Setter
@Getter
public class RolesAction {

    /**
     * 请求ID
     *
     * @mbg.generated
     */
    private Long actionId;

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
