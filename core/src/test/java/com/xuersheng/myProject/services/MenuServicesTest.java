package com.xuersheng.myProject.services;

import com.xuersheng.myProject.ApplicationBaseTest;
import com.xuersheng.myProject.mapper.MenuMapper;
import com.xuersheng.myProject.model.Menu;
import com.xuersheng.myProject.model.dto.MenuDto;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class MenuServicesTest extends ApplicationBaseTest {

    @Resource
    MenuServices menuServices;

    @Resource
    MenuMapper menuMapper;


    @Test
    public void queryMenus() {
    }

    @Test
    public void addMenu() {
        MenuDto dto = new MenuDto();
        dto.setName("test");
        dto.setPid(0L);
        dto.setComponent("test");
        dto.setPath("233");
        dto.setSort(1L);
        boolean b = menuServices.addMenu(dto);
        assertTrue(b);
        Long id = dto.getId();
        Menu menu = menuMapper.selectByPrimaryKey(id);
        Assert.assertEquals(dto.getName(), menu.getName());
        int i = menuMapper.deleteByPrimaryKey(id);
        assertEquals(1, i);
    }

    @Test
    public void editMenu() {
    }

    @Test
    public void deleteMenu() {
    }

    @Test
    public void exe(){

    }
}