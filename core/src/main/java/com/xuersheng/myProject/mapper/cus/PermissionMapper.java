package com.xuersheng.myProject.mapper.cus;

import com.xuersheng.myProject.model.Role;
import com.xuersheng.myProject.model.dto.RoleDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {

    int countActionsByRole(@Param("roleIds") List<Long> roleIds, @Param("path") String path);

    List<Role> selectRoles(RoleDto roleDto);

}
