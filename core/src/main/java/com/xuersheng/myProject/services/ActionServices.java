package com.xuersheng.myProject.services;

import com.xuersheng.myProject.db.DataSource;
import com.xuersheng.myProject.mapper.ActionMapper;
import com.xuersheng.myProject.model.Action;
import com.xuersheng.myProject.model.dto.ActionDto;
import com.xuersheng.myProject.model.example.ActionExample;
import com.xuersheng.myProject.model.vo.ActionVo;
import com.xuersheng.myProject.util.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@DataSource("default")
@Transactional
public class ActionServices {

    @Resource
    ActionMapper actionMapper;


    public List<ActionVo> queryActions(ActionDto actionDto) {
        ActionExample actionExample = new ActionExample();
        ActionExample.Criteria criteria = actionExample.createCriteria();
        if (actionDto.getMenuId() != null) {
            criteria.andMenuIdEqualTo(actionDto.getMenuId());
        }
        List<Action> actions = actionMapper.selectByExample(actionExample);
        return BeanUtils.copyListDeeply(actions, ActionVo.class);
    }

    public boolean addAction(ActionDto actionDto) {
        Action action = new Action();
        BeanUtils.copyPropertiesDeeply(actionDto, action);
        action.setId(null);
        action.setVersion(0);
        action.setDeleted(false);
        return 1 == actionMapper.insert(action);
    }

    public boolean modifyAction(ActionDto actionDto) {
        Action action = new Action();
        BeanUtils.copyPropertiesDeeply(actionDto, action);
        return updateActionByVersion(action);
    }

    public boolean removeAction(ActionDto actionDto) {
        Action action = new Action();
        action.setDeleted(true);
        BeanUtils.copyPropertiesDeeply(actionDto, action);
        return updateActionByVersion(action);
    }

    private boolean updateActionByVersion(Action action) {
        ActionExample actionExample = new ActionExample();
        actionExample.createCriteria()
                .andIdEqualTo(action.getId())
                .andVersionEqualTo(action.getVersion());
        action.setVersion(action.getVersion() + 1);
        return 1 == actionMapper.updateByExampleSelective(action, actionExample);
    }
}
