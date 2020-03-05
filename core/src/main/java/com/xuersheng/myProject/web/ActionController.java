package com.xuersheng.myProject.web;

import com.xuersheng.myProject.services.ActionServices;
import com.xuersheng.myProject.model.dto.ActionDto;
import com.xuersheng.myProject.model.vo.ActionVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

import static com.xuersheng.myProject.util.ResponseBuilder.*;

@RestController
@RequestMapping("/action")
public class ActionController {

    @Resource
    ActionServices actionServices;

    @PostMapping("query")
    public ResponseEntity queryActions(@RequestBody ActionDto actionDto) {
        List<ActionVo> menus = actionServices.queryActions(actionDto);
        return success(menus);
    }

    @PostMapping("add")
    public ResponseEntity addAction(@RequestBody ActionDto actionDto) {
        return actionServices.addAction(actionDto) ?
                success(actionDto.getId()) : error(ADD_ERROR);
    }

    @PostMapping("modify")
    public ResponseEntity Action(@RequestBody ActionDto actionDto) {
        return actionServices.modifyAction(actionDto) ?
                success() : error(MODIFY_ERROR);
    }

    @PostMapping("remove")
    public ResponseEntity removeAction(@RequestBody ActionDto actionDto) {
        return actionServices.removeAction(actionDto) ?
                success() : error(REMOVE_ERROR);
    }

}
