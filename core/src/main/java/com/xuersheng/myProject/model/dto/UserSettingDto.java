package com.xuersheng.myProject.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSettingDto {

    private Long id;

    private Long userId;

    private Long roleId;

    private Integer pageSize;

    private Boolean deleted;

    private Integer version;

}
