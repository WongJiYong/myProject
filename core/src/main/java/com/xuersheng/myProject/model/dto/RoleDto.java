package com.xuersheng.myProject.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleDto {

    private Long id;

    private String name;

    private Boolean enabled;

    private Integer version;
}
