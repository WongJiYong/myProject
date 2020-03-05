package com.xuersheng.myProject.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
public class UserDto {

    private Long id;

    private String email;

    private String username;

    private String password;

    private String phone;

    private String sex;

    private Boolean enabled;

    private Boolean locked;

    private Integer version;

    private PageDto page;
}
