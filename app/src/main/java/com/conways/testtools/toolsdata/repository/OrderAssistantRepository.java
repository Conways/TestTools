package com.conways.testtools.toolsdata.repository;

import com.conways.testtools.toolsdata.ToolsFactory;
import com.conways.testtools.toolsdata.entity.Tool;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class OrderAssistantRepository extends BaseRepository{
    private static final OrderAssistantRepository ourInstance = new OrderAssistantRepository();

    public static OrderAssistantRepository getInstance() {
        return ourInstance;
    }

    private OrderAssistantRepository() {
        super();
    }

    @Override
    public List<Tool> getTools() {
        tools.clear();
        tools.addAll(ToolsFactory.createTools(ToolsFactory.ORDER_ASSISTANT));
        return tools;
    }


    @Override
    public String getTitle() {
        return "接单助手";
    }
}
