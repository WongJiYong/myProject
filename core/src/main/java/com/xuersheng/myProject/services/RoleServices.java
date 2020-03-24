package com.xuersheng.myProject.services;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.*;
import com.xuersheng.myProject.model.*;
import com.xuersheng.myProject.model.dto.RoleActionDto;
import com.xuersheng.myProject.model.dto.RoleDto;
import com.xuersheng.myProject.model.dto.RoleMenuDto;
import com.xuersheng.myProject.model.example.RoleExample;
import com.xuersheng.myProject.model.example.RolesActionExample;
import com.xuersheng.myProject.model.example.RolesMenusExample;
import com.xuersheng.myProject.model.vo.RoleVo;
import com.xuersheng.myProject.util.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@DataSource("default")
@Transactional
public class RoleServices {

    @Resource
    RoleMapper roleMapper;

    @Resource
    ActionMapper actionMapper;

    @Resource
    MenuMapper menuMapper;

    @Resource
    RolesMenusMapper rolesMenusMapper;

    @Resource
    RolesActionMapper rolesActionMapper;

    public List<RoleVo> queryRolesAndActionIdsAndMenuIds(RoleDto roleDto) {
        List<Role> roles = roleMapper.selectRolesAndActionIdsAndMenuIds(roleDto);
        return BeanUtils.copyListDeeply(roles, RoleVo.class);
    }

    public boolean hasAction(List<Long> roleIds, String path) {
        return roleMapper.countActionsByRole(roleIds, path) > 0;
    }

    public boolean addRole(RoleDto roleDto) {
        Role role = new Role();
        role.setVersion(1);
        role.setDeleted(false);
        role.setCreateTime(new Date());
        BeanUtils.copyPropertiesDeeply(roleDto, role);
        return 1 == roleMapper.insert(role);
    }

    public boolean modifyRole(RoleDto roleDto) {
        Role role = new Role();
        BeanUtils.copyPropertiesDeeply(roleDto, role);
        return updateRoleByVersion(role);
    }

    public boolean removeRole(RoleDto roleDto) {
        Long roleId = roleDto.getId();
        //检查数据库外键关系
        RolesMenusExample rolesMenusExample = new RolesMenusExample();
        rolesMenusExample.createCriteria()
                .andRoleIdEqualTo(roleId)
                .andDeletedEqualTo(false);
        int size = rolesMenusMapper.selectByExample(rolesMenusExample).size();
        if (size != 0) {
            return false;
        }
        RolesActionExample rolesActionExample = new RolesActionExample();
        rolesActionExample.createCriteria()
                .andRoleIdEqualTo(roleId)
                .andDeletedEqualTo(false);
        size = rolesActionMapper.selectByExample(rolesActionExample).size();
        if (size != 0) {
            return false;
        }
        Role role = new Role();
        role.setId(roleDto.getId());
        role.setVersion(roleDto.getVersion());
        role.setDeleted(true);
        return updateRoleByVersion(role);
    }

    public boolean addAction(RoleActionDto dto) {
        RolesAction rolesAction = new RolesAction();
        BeanUtils.copyPropertiesDeeply(dto, rolesAction);
        rolesAction.setDeleted(false);
        return saveOrUpdateAction(rolesAction);
    }

    public boolean removeAction(RoleActionDto dto) {
        RolesAction rolesAction = new RolesAction();
        BeanUtils.copyPropertiesDeeply(dto, rolesAction);
        rolesAction.setDeleted(true);
        return saveOrUpdateAction(rolesAction);
    }

    public boolean removeMenu(RoleMenuDto dto) {
        RolesMenus rolesMenus = new RolesMenus();
        BeanUtils.copyPropertiesDeeply(dto, rolesMenus);
        rolesMenus.setDeleted(true);
        return saveOrUpdateMenu(rolesMenus);
    }

    public boolean addMenu(RoleMenuDto dto) {
        RolesMenus rolesMenus = new RolesMenus();
        BeanUtils.copyPropertiesDeeply(dto, rolesMenus);
        rolesMenus.setDeleted(false);
        return saveOrUpdateMenu(rolesMenus);
    }

    private boolean saveOrUpdateAction(RolesAction rolesAction) {
        Long roleId = rolesAction.getRoleId();
        Long actionId = rolesAction.getActionId();
        //check roleId and actionId
        Role role = roleMapper.selectByPrimaryKey(roleId);
        Action action = actionMapper.selectByPrimaryKey(actionId);
        Assert.isTrue(role != null, "role must not be null");
        Assert.isTrue(action != null, "action must not be null");
        RolesAction rolesAction2 = rolesActionMapper.selectByPrimaryKey(actionId, roleId);
        if (rolesAction2 == null) {
            return 1 == rolesActionMapper.insert(rolesAction);
        } else {
            return 1 == rolesActionMapper.updateByPrimaryKeySelective(rolesAction);
        }
    }

    private boolean saveOrUpdateMenu(RolesMenus rolesMenus) {
        Long menuId = rolesMenus.getMenuId();
        Long roleId = rolesMenus.getRoleId();
        //check roleId and menuId
        Menu menu = menuMapper.selectByPrimaryKey(menuId);
        Role role = roleMapper.selectByPrimaryKey(roleId);
        Assert.isTrue(role != null, "role must not be null");
        Assert.isTrue(menu != null, "menu must not be null");
        RolesMenus rolesMenus2 = rolesMenusMapper.selectByPrimaryKey(menuId, roleId);
        if (rolesMenus2 == null) {
            return 1 == rolesMenusMapper.insert(rolesMenus);
        } else {
            return 1 == rolesMenusMapper.updateByPrimaryKeySelective(rolesMenus);
        }
    }

    private boolean updateRoleByVersion(Role role) {
        RoleExample example = new RoleExample();
        example.createCriteria()
                .andIdEqualTo(role.getId())
                .andVersionEqualTo(role.getVersion());
        role.setVersion(role.getVersion() + 1);
        return 1 == roleMapper.updateByExampleSelective(role, example);
    }
}
