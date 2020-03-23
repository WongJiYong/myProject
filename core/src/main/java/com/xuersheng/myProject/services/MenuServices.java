package com.xuersheng.myProject.services;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.ActionMapper;
import com.xuersheng.myProject.mapper.MenuMapper;
import com.xuersheng.myProject.model.Menu;
import com.xuersheng.myProject.model.dto.MenuDto;
import com.xuersheng.myProject.model.example.ActionExample;
import com.xuersheng.myProject.model.example.MenuExample;
import com.xuersheng.myProject.model.vo.MenuVo;
import com.xuersheng.myProject.util.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@DataSource("default")
@Transactional
public class MenuServices {

    @Resource
    MenuMapper menuMapper;

    @Resource
    ActionMapper actionMapper;

    /**
     * 登录用户使用
     * @param roleId 登录用户的角色
     * @return 可用菜单和请求
     */
    public List<MenuVo> queryMenusByRoleId(Long roleId) {
        List<Menu> menus = menuMapper.selectMenusByRoleId(roleId);
        return BeanUtils.copyListDeeply(menus, MenuVo.class);
    }

    /**
     * 查询所有的菜单和菜单下的请求
     * 菜单管理使用
     * @param menuDto 查询菜单条件
     * @return 菜单和请求
     */
    public List<MenuVo> queryMenus(MenuDto menuDto) {
        List<Menu> menus = menuMapper.selectMenus();
        return BeanUtils.copyListDeeply(menus, MenuVo.class);
    }

    public boolean addMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyPropertiesDeeply(menuDto, menu);
        menu.setCreateTime(new Date());
        menu.setDeleted(false);
        menu.setVersion(0);
        menu.setEnabled(true);
        return 1 == menuMapper.insertSelective(menu);
    }

    public boolean modifyMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyPropertiesDeeply(menuDto, menu);
        return updateMenuByVersion(menu);
    }

    public boolean removeMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        //数据校验
        Long id = menuDto.getId();
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria()
                .andPidEqualTo(id);
        long children = menuMapper.countByExample(menuExample);
        if (children > 0) {
            return false;
        }
        ActionExample actionExample = new ActionExample();
        actionExample.createCriteria()
                .andMenuIdEqualTo(id);
        long actions = actionMapper.countByExample(actionExample);
        if (actions > 0) {
            return false;
        }
        BeanUtils.copyPropertiesDeeply(menuDto, menu);
        menu.setDeleted(true);
        return updateMenuByVersion(menu);
    }

    private boolean updateMenuByVersion(Menu menu) {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria()
                .andIdEqualTo(menu.getId())
                .andVersionEqualTo(menu.getVersion());
        menu.setVersion(menu.getVersion() + 1);
        return 1 == menuMapper.updateByExampleSelective(menu, menuExample);
    }

}
