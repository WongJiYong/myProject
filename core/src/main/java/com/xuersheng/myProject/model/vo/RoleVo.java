package com.xuersheng.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class RoleVo {

    private Long id;

    private String name;

    private String code;

    private String remark;

    private Date createTime;

    private Boolean locked;

    private Integer version;

    private List<Long> menuIds;

    private List<Long> actionIds;

    private List<MenuVo> menus;
}
