package com.xuersheng.myProject.mapper;

import com.xuersheng.myProject.model.Role;
import com.xuersheng.myProject.model.example.RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.xuersheng.myProject.model.dto.RoleDto;

public interface RoleMapper {

    long countByExample(RoleExample example);

    int deleteByExample(RoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    List<Role> selectByExample(RoleExample example);

    Role selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    int countActionsByRole(@Param("roleIds") List<Long> roleIds, @Param("path") String path);

    List<Role> selectRolesAndActionIdsAndMenuIds(RoleDto roleDto);
}
