package com.conways.testtools.toolsdata;

import com.conways.testtools.toolsdata.entity.ToolItem;
import com.conways.testtools.toolsdata.repository.ActivityPolicyRepository;
import com.conways.testtools.toolsdata.repository.CommonFunctionRepository;
import com.conways.testtools.toolsdata.repository.DriverServerRepository;
import com.conways.testtools.toolsdata.repository.OrderAssistantRepository;
import com.conways.testtools.toolsdata.repository.ShortCutRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class ToolsManager {
    private static final ToolsManager ourInstance = new ToolsManager();

    public static ToolsManager getInstance() {
        return ourInstance;
    }

    private ToolsManager() {
        toolItems=new ArrayList<>();
    }

    private List<ToolItem> toolItems;



    public List<ToolItem> getToolItems(){
        toolItems.clear();
        toolItems.add(new ToolItem(ToolsFactory.SHORTCUT,ShortCutRepository.getInstance().getTitle(), ShortCutRepository.getInstance().getTools()));
        toolItems.add(new ToolItem(ToolsFactory.COMMON_FUNCTION,CommonFunctionRepository.getInstance().getTitle(), CommonFunctionRepository.getInstance().getTools()));
        toolItems.add(new ToolItem(ToolsFactory.ORDER_ASSISTANT,OrderAssistantRepository.getInstance().getTitle(), OrderAssistantRepository.getInstance().getTools()));
        toolItems.add(new ToolItem(ToolsFactory.ACTIVITY_POLICY,ActivityPolicyRepository.getInstance().getTitle(), ActivityPolicyRepository.getInstance().getTools()));
        toolItems.add(new ToolItem(ToolsFactory.DRIVER_SERVER,DriverServerRepository.getInstance().getTitle(), DriverServerRepository.getInstance().getTools()));
        return toolItems;
    }
}
