package com.xuersheng.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MenuVo {

    private Long id;

    private String name;

    private String component;

    private Long pid;

    private Long sort;

    private String icon;

    private String path;

    private Boolean enabled;

    private Integer version;

    private List<ActionVo> actions;

}
