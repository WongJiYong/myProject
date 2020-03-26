package com.xuersheng.myProject.services;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.ActionMapper;
import com.xuersheng.myProject.mapper.MenuMapper;
import com.xuersheng.myProject.mapper.RoleMapper;
import com.xuersheng.myProject.model.Menu;
import com.xuersheng.myProject.model.Role;
import com.xuersheng.myProject.model.dto.MenuDto;
import com.xuersheng.myProject.model.dto.RoleDto;
import com.xuersheng.myProject.model.example.ActionExample;
import com.xuersheng.myProject.model.example.MenuExample;
import com.xuersheng.myProject.model.example.RoleExample;
import com.xuersheng.myProject.model.vo.MenuVo;
import com.xuersheng.myProject.util.BeanUtils;
import com.xuersheng.myProject.util.SecurityContextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

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

    @Resource
    RoleMapper roleMapper;

    /**
     * 登录用户使用
     *
     * @param roleDto 登录用户的角色
     * @return 可用菜单和请求
     */
    public List<MenuVo> queryMenusByRole(RoleDto roleDto) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();

        Long roleId;
        if (StringUtils.hasText(roleDto.getCode())) {
            criteria.andCodeEqualTo(roleDto.getCode());
            criteria.andDeletedEqualTo(false);
            criteria.andLockedEqualTo(false);
            List<Role> roles = roleMapper.selectByExample(roleExample);
            Assert.isTrue(roles.size() == 1, "discover more then one role.");
            boolean contains = SecurityContextUtils.getRoles().contains(roles.get(0).getCode());
            Assert.isTrue(contains, "Insufficient authority");
            roleId = roles.get(0).getId();
        } else {
            roleId = SecurityContextUtils.getUser().getUserSetting().getRoleId();
        }
        List<Menu> menus = menuMapper.selectMenusByRoleId(roleId);
        return BeanUtils.copyListDeeply(menus, MenuVo.class);
    }

    /**
     * 查询所有的菜单
     * 菜单管理使用
     *
     * @param menuDto 查询菜单条件
     * @return 菜单和请求
     */
    public List<MenuVo> queryMenus(MenuDto menuDto) {
        List<Menu> menus = menuMapper.selectMenus(menuDto);
        return BeanUtils.copyListDeeply(menus, MenuVo.class);
    }

    public boolean addMenu(MenuDto menuDto) {
        Menu menu = new Menu();
        BeanUtils.copyPropertiesDeeply(menuDto, menu);
        menu.setCreateTime(new Date());
        menu.setDeleted(false);
        menu.setVersion(0);
        return 1 == menuMapper.insert(menu);
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
                .andPidEqualTo(id)
                .andDeletedEqualTo(false);
        long children = menuMapper.countByExample(menuExample);
        Assert.isTrue(children == 0, "the menu has children.");
        ActionExample actionExample = new ActionExample();
        actionExample.createCriteria()
                .andMenuIdEqualTo(id)
                .andDeletedEqualTo(false);
        long actions = actionMapper.countByExample(actionExample);
        Assert.isTrue(actions == 0, "the menu has actions");
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
