package com.xuersheng.myProject.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

/**
 * table menu
 */
@Setter
@Getter
public class Menu {

    /**
     * ID
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 是否外链
     *
     * @mbg.generated
     */
    private Boolean iFrame;

    /**
     * 菜单名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 组件
     *
     * @mbg.generated
     */
    private String component;

    /**
     * 上级菜单ID
     *
     * @mbg.generated
     */
    private Long pid;

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
     * 链接地址
     *
     * @mbg.generated
     */
    private String path;

    /**
     * 缓存
     *
     * @mbg.generated
     */
    private Boolean cache;

    /**
     * 是否启用
     *
     * @mbg.generated
     */
    private Boolean enabled;

    /**
     * 组件名称
     *
     * @mbg.generated
     */
    private String componentName;

    /**
     * 创建日期
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 权限
     *
     * @mbg.generated
     */
    private String permission;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private Integer type;

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

    private List<Action> actions;
}
