package com.xuersheng.myProject.web;

import com.xuersheng.myProject.services.ActionServices;
import com.xuersheng.myProject.model.dto.ActionDto;
import com.xuersheng.myProject.model.vo.ActionVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

import static com.xuersheng.myProject.util.ResponseBuilder.*;

@RestController
@RequestMapping("/action")
public class ActionController {

    @Resource
    ActionServices actionServices;

    @GetMapping("query")
    public ResponseEntity<Object> queryActions(ActionDto actionDto) {
        List<ActionVo> menus = actionServices.queryActions(actionDto);
        return success(menus);
    }

    @PostMapping("add")
    public ResponseEntity<Object> addAction(@RequestBody ActionDto actionDto) {
        return actionServices.addAction(actionDto) ?
                success(actionDto.getId()) : error(ADD_ERROR);
    }

    @PostMapping("modify")
    public ResponseEntity<Object> modifyAction(@RequestBody ActionDto actionDto) {
        return actionServices.modifyAction(actionDto) ?
                success() : error(MODIFY_ERROR);
    }

    @PostMapping("remove")
    public ResponseEntity<Object> removeAction(@RequestBody ActionDto actionDto) {
        return actionServices.removeAction(actionDto) ?
                success() : error(REMOVE_ERROR);
    }

}
