package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table action
 */
@Setter
@Getter
public class Action {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 按钮功能（增删改查）
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 菜单ID
     *
     * @mbg.generated
     */
    private Long menuId;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Long sort;

    /**
     * 图标
     *
     * @mbg.generated
     */
    private String icon;

    /**
     * 该地址用来控制请求权限
     *
     * @mbg.generated
     */
    private String path;

    /**
     * 锁定（页面显示但是不能用）
     *
     * @mbg.generated
     */
    private Boolean locked;

    /**
     * 启用（页面不显示）
     *
     * @mbg.generated
     */
    private Boolean enabled;

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
