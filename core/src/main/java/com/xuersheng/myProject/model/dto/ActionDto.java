package com.xuersheng.myProject.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ActionDto {

    private Long id;

    private String name;

    private Long menuId;

    private String icon;

    private String path;

    private Boolean locked;

    private Boolean enabled;

    private Integer version;

}
