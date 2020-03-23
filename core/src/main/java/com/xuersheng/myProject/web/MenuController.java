package com.xuersheng.myProject.web;

import com.xuersheng.myProject.services.MenuServices;
import com.xuersheng.myProject.model.UserSetting;
import com.xuersheng.myProject.model.dto.MenuDto;
import com.xuersheng.myProject.model.dto.RoleDto;
import com.xuersheng.myProject.model.vo.MenuVo;
import com.xuersheng.myProject.util.SecurityContextUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.xuersheng.myProject.util.ResponseBuilder.ADD_ERROR;
import static com.xuersheng.myProject.util.ResponseBuilder.MODIFY_ERROR;
import static com.xuersheng.myProject.util.ResponseBuilder.REMOVE_ERROR;
import static com.xuersheng.myProject.util.ResponseBuilder.error;
import static com.xuersheng.myProject.util.ResponseBuilder.success;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    MenuServices menuServices;

    /**
     * 授权用户加载指定角色的菜单
     *
     * @param roleDto 指定角色
     * @return 该角色下的菜单
     */
    @GetMapping("load")
    public ResponseEntity<Object> loadMenusByRole(@RequestBody(required = false) RoleDto roleDto) {
        Long roleId = roleDto != null ? roleDto.getId() : null;
        if (roleId == null) {
            UserSetting userSetting = SecurityContextUtils.getUser().getUserSetting();
            if (userSetting == null) {
                return error();
            }
            roleId = userSetting.getRoleId();
        }
        if (roleId == null) {
            return error();
        }
        List<MenuVo> menuVos = menuServices.queryMenusByRoleId(roleId);
        return success(menuVos);
    }

    @GetMapping("query")
    public ResponseEntity<Object> queryMenus(@RequestBody(required = false) MenuDto menuDto) {
        List<MenuVo> menus = menuServices.queryMenus(menuDto);
        return success(menus);
    }

    @PostMapping("add")
    public ResponseEntity<Object> addMenu(@RequestBody MenuDto menuDto) {
        return menuServices.addMenu(menuDto) ?
                success(menuDto.getId()) : error(ADD_ERROR);
    }

    @PostMapping("modify")
    public ResponseEntity<Object> modifyMenu(@RequestBody MenuDto menuDto) {
        return menuServices.modifyMenu(menuDto) ?
                success() : error(MODIFY_ERROR);
    }

    @PostMapping("remove")
    public ResponseEntity<Object> removeMenu(@RequestBody MenuDto menuDto) {
        return menuServices.removeMenu(menuDto) ?
                success() : error(REMOVE_ERROR);
    }

}
