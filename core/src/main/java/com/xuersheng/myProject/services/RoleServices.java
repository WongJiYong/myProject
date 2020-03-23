package com.xuersheng.myProject.services;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.PermissionMapper;
import com.xuersheng.myProject.mapper.RoleMapper;
import com.xuersheng.myProject.mapper.RolesActionMapper;
import com.xuersheng.myProject.mapper.RolesMenusMapper;
import com.xuersheng.myProject.model.Role;
import com.xuersheng.myProject.model.RolesAction;
import com.xuersheng.myProject.model.RolesMenus;
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
    RolesMenusMapper rolesMenusMapper;

    @Resource
    RolesActionMapper rolesActionMapper;

    @Resource
    PermissionMapper permissionMapper;

    public List<RoleVo> queryRolesAndActionIdsAndMenuIds(RoleDto roleDto) {
        List<Role> roles = permissionMapper.selectRoles(roleDto);
        return BeanUtils.copyListDeeply(roles, RoleVo.class);
    }


    public boolean addRole(RoleDto roleDto) {
        Role role = new Role();
        role.setId(null);
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
        RolesAction action = rolesActionMapper.selectByPrimaryKey(rolesAction.getActionId(), rolesAction.getRoleId());
        if (action == null) {
            return 1 == rolesActionMapper.insert(rolesAction);
        } else {
            return 1 == rolesActionMapper.updateByPrimaryKeySelective(rolesAction);
        }
    }

    private boolean saveOrUpdateMenu(RolesMenus rolesMenus) {
        RolesMenus action = rolesMenusMapper.selectByPrimaryKey(rolesMenus.getMenuId(), rolesMenus.getRoleId());
        if (action == null) {
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
