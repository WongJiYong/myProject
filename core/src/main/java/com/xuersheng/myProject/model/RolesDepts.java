package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table roles_depts
 */
@Setter
@Getter
public class RolesDepts {

    /**
     * @mbg.generated
     */
    private Long roleId;

    /**
     * @mbg.generated
     */
    private Long deptId;

    /**
     * 逻辑删除位
     *
     * @mbg.generated
     */
    private Boolean deleted;

    /**
     * 版本号
     *
     * @mbg.generated
     */
    private Integer version;
}
