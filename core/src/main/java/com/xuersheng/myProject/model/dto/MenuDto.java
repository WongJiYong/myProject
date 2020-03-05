package com.xuersheng.myProject.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class MenuDto {

    private Long id;

    private String name;

    private String component;

    private Long pid;

    private Long sort;

    private String icon;

    private String path;

    private Boolean enabled;

    private Date createTime;

    private Integer version;

    private String roleName;

}
