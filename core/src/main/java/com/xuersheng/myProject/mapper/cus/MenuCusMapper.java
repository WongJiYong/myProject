package com.xuersheng.myProject.mapper.cus;

import com.xuersheng.myProject.model.Menu;

import java.util.List;

public interface MenuCusMapper {

    List<Menu> selectMenusByRoleId(Long roleId);

    List<Menu> selectMenus();
}
