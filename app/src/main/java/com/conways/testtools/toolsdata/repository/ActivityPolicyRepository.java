package com.conways.testtools.toolsdata.repository;

import com.conways.testtools.toolsdata.ToolsFactory;
import com.conways.testtools.toolsdata.entity.Tool;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class ActivityPolicyRepository extends BaseRepository{
    private static final ActivityPolicyRepository ourInstance = new ActivityPolicyRepository();

    public static ActivityPolicyRepository getInstance() {
        return ourInstance;
    }

    private ActivityPolicyRepository() {
        super();
    }

    @Override
    public List<Tool> getTools() {
        tools.clear();
        tools.addAll(ToolsFactory.createTools(ToolsFactory.ACTIVITY_POLICY));
        return tools;
    }


    @Override
    public String getTitle() {
        return "活动政策";
    }
}
