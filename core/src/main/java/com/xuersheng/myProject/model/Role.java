package com.xuersheng.myProject.model;

import com.xuersheng.myProject.model.base.BaseRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Role extends BaseRole {

    private List<Long> menuIds;

    private List<Long> actionIds;
}