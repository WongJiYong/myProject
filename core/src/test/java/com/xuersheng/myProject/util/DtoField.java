package com.xuersheng.myProject.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import com.xuersheng.myProject.model.dto.*;

@Slf4j
public class DtoField {
    Set<Class<?>> dtos = new HashSet<>();

    {
        dtos.add(ActionDto.class);
        dtos.add(CatalogDto.class);
        dtos.add(DictionaryFormInfo.class);
        dtos.add(MenuDto.class);
        dtos.add(PageDto.class);
        dtos.add(RoleActionDto.class);
        dtos.add(RoleDto.class);
        dtos.add(RoleMenuDto.class);
        dtos.add(ServerInfoParamsDto.class);
        dtos.add(UserDto.class);
        dtos.add(UserRoleDto.class);
        dtos.add(UserSettingDto.class);
    }

    Set<String> fields = new HashSet<>();

    @Test
    public void findFields() {
        for (Class<?> dto : dtos) {
            PropertyDescriptor[] desc = BeanUtils.getPropertyDescriptors(dto);
            for (PropertyDescriptor propertyDescriptor : desc) {
                fields.add(propertyDescriptor.getName());
            }
        }
        fields.remove("class");
        for (String field : fields) {
            log.info(field);
        }
    }

    @Test
    public void exe() {
        String ss = "null";
        log.info("123{}", ss);
        ss = null;
        log.info("123{}", ss);
    }

}
