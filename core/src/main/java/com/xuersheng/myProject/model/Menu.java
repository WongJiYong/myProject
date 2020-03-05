package com.xuersheng.myProject.model;

import com.xuersheng.myProject.model.base.BaseMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Menu extends BaseMenu {
    private List<Action> actions;
}