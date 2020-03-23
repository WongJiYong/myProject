package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * table role
 */
@Setter
@Getter
public class Role {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * 数据权限
     *
     * @mbg.generated
     */
    private String dataScope;

    /**
     * 角色级别
     *
     * @mbg.generated
     */
    private Integer level;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 功能权限
     *
     * @mbg.generated
     */
    private String permission;

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

    private List<Long> menuIds;

    private List<Long> actionIds;
}
