package com.xuersheng.myProject.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuersheng.myProject.mapper.*;
import com.xuersheng.myProject.model.*;
import com.xuersheng.myProject.model.dto.RoleActionDto;
import com.xuersheng.myProject.model.dto.RoleDto;
import com.xuersheng.myProject.model.dto.RoleMenuDto;
import com.xuersheng.myProject.model.vo.ResultVo;
import com.xuersheng.myProject.model.vo.RoleVo;
import com.xuersheng.myProject.util.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@Slf4j
@WithUserDetails("admin")
@Rollback
@Transactional(rollbackFor = Exception.class)
public class RoleControllerTest extends BaseControllerTest {

    @Resource
    ActionMapper actionMapper;
    @Resource
    MenuMapper menuMapper;
    @Resource
    RolesMenusMapper rolesMenusMapper;
    @Resource
    RolesActionMapper rolesActionMapper;
    @Resource
    RoleMapper roleMapper;

    static String[] fields = {
            "name",
            "code",
            "remark",
            "locked",
            "version",
    };

    static class URL {
        static String query = "/role/query";
        static String add = "/role/add";
        static String modify = "/role/modify";
        static String remove = "/role/remove";
        static String addAction = "/role/action/add";
        static String removeAction = "/role/action/remove";
        static String addMenu = "/role/menu/add";
        static String removeMenu = "/role/menu/remove";
    }

    @Test
    public void integrateTest() throws Exception {

        RoleDto roleDto = TestUtil.randomObject(RoleDto.class, fields);
        RoleVo roleVo;

        addRole(roleDto);
        roleVo = querySingleRoles(roleDto);

        RoleDto modifyDto = TestUtil.randomObject(RoleDto.class, fields);
        modifyDto.setLocked(!roleVo.getLocked());
        modifyDto.setVersion(roleVo.getVersion());
        modifyDto.setId(roleVo.getId());
        modifyRole(modifyDto);

        roleVo = querySingleRoles(modifyDto);
        assertNotEquals(roleVo.getVersion(), modifyDto.getVersion());
        modifyDto.setVersion(roleVo.getVersion());

        assert TestUtil.equalsObjs(roleVo, modifyDto);
        roleDto = modifyDto;
        RoleActionDto dto = new RoleActionDto();
        dto.setRoleId(roleVo.getId());
        //insert a temp action
        Action action = TestUtil.randomObject(Action.class);
        actionMapper.insert(action);
        dto.setActionId(action.getId());
        addAction(dto);
        RolesAction rolesAction = rolesActionMapper.selectByPrimaryKey(dto.getActionId(), dto.getRoleId());
        assert !rolesAction.getDeleted();
        removeAction(dto);
        rolesAction = rolesActionMapper.selectByPrimaryKey(dto.getActionId(), dto.getRoleId());
        assert rolesAction.getDeleted();


        RoleMenuDto roleMenuDto = new RoleMenuDto();
        Menu menu = TestUtil.randomObject(Menu.class);
        //insert a temp menu
        menuMapper.insert(menu);
        roleMenuDto.setRoleId(roleVo.getId());
        roleMenuDto.setMenuId(menu.getId());
        addMenu(roleMenuDto);
        RolesMenus rolesMenus = rolesMenusMapper.selectByPrimaryKey(roleMenuDto.getMenuId(), roleMenuDto.getRoleId());
        assert !rolesMenus.getDeleted();
        removeMenu(roleMenuDto);
        rolesMenus = rolesMenusMapper.selectByPrimaryKey(roleMenuDto.getMenuId(), roleMenuDto.getRoleId());
        assert rolesMenus.getDeleted();

        roleDto.setVersion(roleVo.getVersion());
        removeRole(roleDto);
        Role role = roleMapper.selectByPrimaryKey(roleDto.getId());
        assert role.getDeleted();
    }

    private List<RoleVo> queryRoles(RoleDto dto) throws Exception {
        String content = httpGet(URL.query, dto);
        ResultVo<List<RoleVo>> obj = new ObjectMapper().readValue(content,
                new TypeReference<ResultVo<List<RoleVo>>>() {
                });
        return obj.getData();
    }

    private RoleVo querySingleRoles(RoleDto dto) throws Exception {
        List<RoleVo> roleVos = queryRoles(dto);
        assertEquals(1, roleVos.size());
        return roleVos.get(0);
    }


    private void addRole(RoleDto dto) throws Exception {
        httpPost(URL.add, dto);
    }

    private void modifyRole(RoleDto dto) throws Exception {
        httpPost(URL.modify, dto);
    }

    private void removeRole(RoleDto dto) throws Exception {
        httpPost(URL.remove, dto);
    }

    private void addAction(RoleActionDto dto) throws Exception {
        httpPost(URL.addAction, dto);
    }

    private void removeAction(RoleActionDto dto) throws Exception {
        httpPost(URL.removeAction, dto);
    }

    private void addMenu(RoleMenuDto dto) throws Exception {
        httpPost(URL.addMenu, dto);
    }

    private void removeMenu(RoleMenuDto dto) throws Exception {
        httpPost(URL.removeMenu, dto);
    }
}