package com.xuersheng.myProject.web;

import com.xuersheng.myProject.model.dto.MenuDto;
import com.xuersheng.myProject.model.dto.RoleDto;
import com.xuersheng.myProject.model.vo.MenuVo;
import com.xuersheng.myProject.services.MenuServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.xuersheng.myProject.util.ResponseBuilder.*;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Resource
    MenuServices menuServices;

    /**
     * 授权用户加载指定角色的菜单
     *
     * @return 该角色下的菜单
     */
    @GetMapping("load")
    public ResponseEntity<Object> loadMenusByRole(RoleDto roleDto) {
        List<MenuVo> menuVos = menuServices.queryMenusByRole(roleDto);
        return success(menuVos);
    }

    @GetMapping("query")
    public ResponseEntity<Object> queryMenus(MenuDto menuDto) {
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
