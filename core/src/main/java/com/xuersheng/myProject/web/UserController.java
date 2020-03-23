package com.xuersheng.myProject.web;

import com.xuersheng.myProject.model.dto.UserDto;
import com.xuersheng.myProject.model.dto.UserRoleDto;
import com.xuersheng.myProject.model.dto.UserSettingDto;
import com.xuersheng.myProject.model.vo.PageVo;
import com.xuersheng.myProject.model.vo.UserVo;
import com.xuersheng.myProject.services.UserServices;
import com.xuersheng.myProject.util.ResponseBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServices userServices;

    /**
     * 已授权用户查询详细信息
     *
     * @return 用户详细信息 包括角色信息
     */
    @GetMapping("info")
    public ResponseEntity<Object> userDetailInfo() {
        UserVo userVo = userServices.userDetailInfo();
        return ResponseBuilder.success(userVo);
    }

    /**
     * 已授权用户 修改配置文件
     *
     * @param dto UserSettingDto
     * @return jsonResp
     */
    @PostMapping("setting/modify")
    public ResponseEntity<Object> modifySetting(@RequestBody UserSettingDto dto) {
        return userServices.modifySetting(dto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.MODIFY_ERROR);
    }

    /**
     * 管理员锁定用户的接口
     *
     * @param dto UserDto
     * @return ResponseEntity
     */
    @PostMapping("lock")
    public ResponseEntity<Object> lockedUser(@RequestBody UserDto dto) {
        boolean b = userServices.lockUser(dto);
        return ResponseBuilder.success(b);
    }


    @PostMapping("query")
    public ResponseEntity<Object> queryUsers(@RequestBody UserDto userDto) {
        PageVo<?> pageVo = userServices.queryUsers(userDto);
        return ResponseBuilder.success(pageVo);
    }


    @PostMapping("add")
    public ResponseEntity<Object> addUser(@RequestBody UserDto userDto) {
        return userServices.addUser(userDto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.ADD_ERROR);
    }

    @PostMapping("modify")
    public ResponseEntity<Object> modifyUser(@RequestBody UserDto userDto) {
        return userServices.modifyUser(userDto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.MODIFY_ERROR);
    }

    @PostMapping("remove")
    public ResponseEntity<Object> removeUser(@RequestBody UserDto userDto) {
        return userServices.removeUser(userDto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.REMOVE_ERROR);
    }

    @PostMapping("role/add")
    public ResponseEntity<Object> addRole(@RequestBody UserRoleDto dto) {
        return userServices.addRole(dto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.ADD_ERROR);
    }

    @PostMapping("role/remove")
    public ResponseEntity<Object> removeRole(@RequestBody UserRoleDto dto) {
        return userServices.removeRole(dto) ?
                ResponseBuilder.success() : ResponseBuilder.error(ResponseBuilder.REMOVE_ERROR);
    }

}
