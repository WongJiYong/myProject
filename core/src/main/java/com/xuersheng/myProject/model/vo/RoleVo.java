package com.xuersheng.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RoleVo {

    private Long id;

    private String name;

    private List<Long> menuIds;

    private List<Long> actionIds;

    private List<MenuVo> menus;
}
