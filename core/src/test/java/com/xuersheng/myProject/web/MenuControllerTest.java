package com.xuersheng.myProject.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuersheng.myProject.model.dto.MenuDto;
import com.xuersheng.myProject.model.dto.RoleDto;
import com.xuersheng.myProject.model.vo.MenuVo;
import com.xuersheng.myProject.model.vo.ResultVo;
import com.xuersheng.myProject.util.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@Slf4j
@Rollback
@Transactional(rollbackFor = Exception.class)
@WithUserDetails("admin")
public class MenuControllerTest extends BaseControllerTest {

    static class URL {
        static String load = "/menu/load";
        static String query = "/menu/query";
        static String add = "/menu/add";
        static String modify = "/menu/modify";
        static String remove = "/menu/remove";
    }

    @Test
    public void integrateTest() throws Exception {

        MenuDto menuDto = TestUtil.randomObject(MenuDto.class);
        addMenu(menuDto);
        menuDto.setId(null);
        menuDto.setVersion(null);
        MenuVo menuVo = querySingleMenus(menuDto);
        menuDto.setId(menuVo.getId());
        menuDto.setVersion(menuVo.getVersion());
        assert TestUtil.equalsObjs(menuVo, menuDto);

        MenuDto modifyDto = TestUtil.randomObject(MenuDto.class);
        modifyDto.setId(menuVo.getId());
        modifyDto.setVersion(menuVo.getVersion());
        modifyMenu(modifyDto);
        menuVo = querySingleMenus(modifyDto);

        assertNotEquals(modifyDto.getVersion(), menuVo.getVersion());
        modifyDto.setVersion(menuVo.getVersion());

        assert TestUtil.equalsObjs(menuVo, modifyDto);

        removeMenu(modifyDto);
        List<MenuVo> menuVos = queryMenus(modifyDto);
        assertEquals(0, menuVos.size());
    }

    @Test
    public void loadMenusByRole() throws Exception {
        RoleDto dto = new RoleDto();
        dto.setCode("admin");
        String content = httpGet(URL.load, dto);
        ResultVo<List<MenuVo>> r = new ObjectMapper().readValue(content, new TypeReference<ResultVo<List<MenuVo>>>() {
        });
        Assert.isTrue(r.getData().size() > 0, "admin role > 1");
    }

    @Test
    public void queryMenus() throws Exception {
//        系统管理
        MenuDto dto = new MenuDto();
        dto.setName("系统管理");
        List<MenuVo> menuVos = queryMenus(dto);
        assertEquals(1, menuVos.size());
    }

    private List<MenuVo> queryMenus(MenuDto dto) throws Exception {
        String content = httpGet(URL.query, dto);
        ResultVo<List<MenuVo>> r = new ObjectMapper().readValue(content, new TypeReference<ResultVo<List<MenuVo>>>() {
        });
        return r.getData();
    }

    private MenuVo querySingleMenus(MenuDto dto) throws Exception {
        List<MenuVo> menuVos = queryMenus(dto);
        assertEquals(1, menuVos.size());
        return menuVos.get(0);
    }

    private void addMenu(MenuDto dto) throws Exception {
        httpPost(URL.add, dto);
    }

    private void modifyMenu(MenuDto dto) throws Exception {
        httpPost(URL.modify, dto);
    }

    private void removeMenu(MenuDto dto) throws Exception {
        httpPost(URL.remove, dto);
    }

}