package com.xuersheng.myProject.services;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@DataSource("default")
public class PermissionServices {

    @Resource
    PermissionMapper permissionMapper;

    public boolean isHasAction(List<Long> roleIds, String path) {
        return permissionMapper.countActionsByRole(roleIds, path) > 0;
    }
}
