package com.xuersheng.myProject.model.vo;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActionVo {

    private Long id;

    private String name;

    private String icon;

    private String path;

    private Boolean locked;

    private Boolean enabled;

    private Integer version;
}
