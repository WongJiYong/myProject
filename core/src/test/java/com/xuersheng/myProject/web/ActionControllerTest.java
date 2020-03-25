package com.xuersheng.myProject.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuersheng.myProject.model.dto.ActionDto;
import com.xuersheng.myProject.model.vo.ActionVo;
import com.xuersheng.myProject.model.vo.ResultVo;
import com.xuersheng.myProject.util.TestUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@Rollback
@Transactional(rollbackFor = Exception.class)
@WithUserDetails("admin")
public class ActionControllerTest extends BaseControllerTest {

    static class URL {
        static String query = "/action/query";
        static String add = "/action/add";
        static String modify = "/action/modify";
        static String remove = "/action/remove";
    }

    @Test
    public void integrateTest() throws Exception {
        ActionDto dto = TestUtil.randomObject(ActionDto.class);
        addAction(dto);
        dto.setId(null);
        ActionVo actionVo = querySingleAction(dto);
        ActionDto modifyDto = TestUtil.randomObject(ActionDto.class);
        modifyDto.setVersion(actionVo.getVersion());
        modifyDto.setId(actionVo.getId());
        modifyAction(modifyDto);
        actionVo = querySingleAction(modifyDto);

        assertNotEquals(actionVo.getVersion(), modifyDto.getVersion());
        modifyDto.setVersion(actionVo.getVersion());
        assert TestUtil.equalsObjs(actionVo, modifyDto);

        removeAction(modifyDto);
        assertEquals(queryActions(modifyDto).size(), 0);
    }

    private List<ActionVo> queryActions(ActionDto dto) throws Exception {
        String jsonResp = httpGet(URL.query, dto);
        ResultVo<List<ActionVo>> resultVo = new ObjectMapper().readValue(jsonResp, new TypeReference<ResultVo<List<ActionVo>>>() {
        });
        return resultVo.getData();
    }

    private ActionVo querySingleAction(ActionDto dto) throws Exception {
        List<ActionVo> actionVos = queryActions(dto);
        assertEquals(1, actionVos.size());
        return actionVos.get(0);
    }

    private void addAction(ActionDto dto) throws Exception {
        httpPost(URL.add, dto);
    }

    private void modifyAction(ActionDto dto) throws Exception {
        httpPost(URL.modify, dto);
    }

    private void removeAction(ActionDto dto) throws Exception {
        httpPost(URL.remove, dto);
    }
}