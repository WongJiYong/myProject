package com.xuersheng.myProject.model;

import lombok.Getter;
import lombok.Setter;

/**
 * table roles_menus
 */
@Setter
@Getter
public class RolesMenus {

    /**
     * 菜单ID
     *
     * @mbg.generated
     */
    private Long menuId;

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
