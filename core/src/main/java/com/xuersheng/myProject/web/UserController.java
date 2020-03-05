package com.xuersheng.myProject.web;

import com.xuersheng.myProject.services.UserServices;
import com.xuersheng.myProject.util.ResponseBuilder;
import com.xuersheng.myProject.model.dto.UserRoleDto;
import com.xuersheng.myProject.model.dto.UserSettingDto;
import com.xuersheng.myProject.model.vo.PageVo;
import com.xuersheng.myProject.model.dto.UserDto;
import com.xuersheng.myProject.model.vo.UserVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServices userServices;

    /**
     * 提供授权用户查询 详细用户信息
     *
     * @return 用户详细信息 包括角色信息
     */
    @GetMapping("info")
    public ResponseEntity userDetailInfo() {
        UserVo userVo = userServices.userDetailInfo();
        return ResponseBuilder.success(userVo);
    }

    /**
     * 管理员锁定用户的接口
     *
     * @param dto UserDto
     * @return ResponseEntity
     */
    @PostMapping("lock")
    public ResponseEntity lockedUser(@RequestBody UserDto dto) {
        boolean b = userServices.lockUser(dto);
        return ResponseBuilder.success(b);
    }

    @PostMapping("setting")
    public ResponseEntity modifySetting(@RequestBody UserSettingDto dto) {
        return userServices.modifySetting(dto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.MODIFY_ERROR);
    }

    @PostMapping("query")
    public ResponseEntity queryUsers(@RequestBody UserDto userDto) {
        PageVo pageVo = userServices.queryUsers(userDto);
        return ResponseBuilder.success(pageVo);
    }

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        return userServices.addUser(userDto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.ADD_ERROR);
    }

    @PostMapping("modify")
    public ResponseEntity modifyUser(@RequestBody UserDto userDto) {
        return userServices.modifyUser(userDto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.MODIFY_ERROR);
    }

    @PostMapping("remove")
    public ResponseEntity removeUser(@RequestBody UserDto userDto) {
        return userServices.removeUser(userDto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.REMOVE_ERROR);
    }

    @PostMapping("/roles/query")
    public ResponseEntity queryRoles(@RequestBody UserDto dto) {
        List<Long> roleIds = userServices.queryUserRoles(dto);
        return ResponseBuilder.success(roleIds);
    }

    @PostMapping("role/add")
    public ResponseEntity addAction(@RequestBody UserRoleDto dto) {
        return userServices.addRole(dto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.ADD_ERROR);
    }

    @PostMapping("role/remove")
    public ResponseEntity removeAction(@RequestBody UserRoleDto dto) {
        return userServices.removeRole(dto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.REMOVE_ERROR);
    }

}
