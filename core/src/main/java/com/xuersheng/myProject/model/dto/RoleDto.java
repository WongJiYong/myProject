package com.xuersheng.myProject.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class RoleDto {

    private Long id;

    private String name;

    private String code;

    private String remark;

    private Date createTime;

    private Boolean locked;

    private Integer version;

}
