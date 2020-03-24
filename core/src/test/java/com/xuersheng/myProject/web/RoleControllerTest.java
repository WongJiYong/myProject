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
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
        List<RoleVo> roleVos = queryRoles(roleDto);
        assert roleVos.size() == 1;
        roleVo = roleVos.get(0);
        roleDto.setId(roleVo.getId());

        RoleDto modifyDto = TestUtil.randomObject(RoleDto.class, fields);
        modifyDto.setLocked(!roleDto.getLocked());
        modifyDto.setVersion(roleVo.getVersion());
        modifyDto.setId(roleDto.getId());
        modifyRole(modifyDto);

        roleVos = queryRoles(modifyDto);
        assert roleVos.size() == 1;
        roleVo = roleVos.get(0);
        roleDto.setId(roleVo.getId());
        TestUtil.equalsObjs(roleVos.get(0), modifyDto, fields);
        //修改用户成功
        log.info("修改用户成功");
        roleDto = modifyDto;

        RoleActionDto dto = new RoleActionDto();
        dto.setRoleId(roleDto.getId());
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
        roleMenuDto.setRoleId(roleDto.getId());
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
        MvcResult mvcResult = this.mvc.perform(
                get(URL.query)
                        .with(csrf().asHeader())
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(json.write(dto).getJson())
                        .accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk()).andReturn();
        String content = mvcResult.getResponse().getContentAsString();
        ResultVo<List<RoleVo>> obj = new ObjectMapper().readValue(content,
                new TypeReference<ResultVo<List<RoleVo>>>() {
                });
        return obj.getData();
    }

    private void addRole(RoleDto dto) throws Exception {
        send(URL.add, dto);
    }

    private void modifyRole(RoleDto dto) throws Exception {
        send(URL.modify, dto);
    }

    private void removeRole(RoleDto dto) throws Exception {
        send(URL.remove, dto);
    }

    private void addAction(RoleActionDto dto) throws Exception {
        send(URL.addAction, dto);
    }

    private void removeAction(RoleActionDto dto) throws Exception {
        send(URL.removeAction, dto);
    }

    private void addMenu(RoleMenuDto dto) throws Exception {
        send(URL.addMenu, dto);
    }

    private void removeMenu(RoleMenuDto dto) throws Exception {
        send(URL.removeMenu, dto);
    }
}