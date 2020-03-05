package com.xuersheng.myProject.web;

import com.xuersheng.myProject.services.RoleServices;
import com.xuersheng.myProject.util.ResponseBuilder;
import com.xuersheng.myProject.model.dto.RoleActionDto;
import com.xuersheng.myProject.model.dto.RoleDto;
import com.xuersheng.myProject.model.dto.RoleMenuDto;
import com.xuersheng.myProject.model.vo.RoleVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    RoleServices roleServices;

    @GetMapping("query")
    public ResponseEntity queryRoles(@RequestBody(required = false) RoleDto roleDto) {
        List<RoleVo> menus = roleServices.queryRolesAndActionIdsAndMenuIds(roleDto);
        return ResponseBuilder.success(menus);
    }

    @PostMapping("add")
    public ResponseEntity addRole(@RequestBody RoleDto roleDto) {
        return roleServices.addRole(roleDto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.ADD_ERROR);
    }

    @PostMapping("modify")
    public ResponseEntity modifyRole(@RequestBody RoleDto roleDto) {
        return roleServices.modifyRole(roleDto)
                ? ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.MODIFY_ERROR);
    }

    @PostMapping("remove")
    public ResponseEntity removeRole(@RequestBody RoleDto roleDto) {
        return roleServices.removeRole(roleDto)
                ? ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.REMOVE_ERROR);
    }

    @PostMapping("action/add")
    public ResponseEntity addAction(@RequestBody RoleActionDto dto) {
        return roleServices.addAction(dto)
                ? ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.ADD_ERROR);
    }

    @PostMapping("action/remove")
    public ResponseEntity removeAction(@RequestBody RoleActionDto dto) {
        return roleServices.removeAction(dto)
                ? ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.REMOVE_ERROR);
    }

    @PostMapping("menu/add")
    public ResponseEntity addMenu(@RequestBody RoleMenuDto dto) {
        return roleServices.addMenu(dto)
                ? ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.ADD_ERROR);
    }

    @PostMapping("menu/remove")
    public ResponseEntity removeMenu(@RequestBody RoleMenuDto dto) {
        return roleServices.removeMenu(dto)
                ? ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.REMOVE_ERROR);
    }

}
