package com.xuersheng.myProject.services;

import com.xuersheng.myProject.ApplicationBaseTest;
import com.xuersheng.myProject.model.dto.ActionDto;
import com.xuersheng.myProject.model.vo.ActionVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.List;

@Slf4j
public class ActionServicesTest extends ApplicationBaseTest {

    @Resource
    ActionServices actionServices;

    @Test
    public void queryActions() {
        ActionDto actionDto = new ActionDto();
        actionDto.setMenuId(1L);
        List<ActionVo> actionVos = actionServices.queryActions(actionDto);
        log.info("actionVos:{}", actionVos);
    }
}