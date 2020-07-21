package com.conways.testtools.toolsdata.repository;

import com.conways.testtools.toolsdata.ToolsFactory;
import com.conways.testtools.toolsdata.entity.Tool;
import com.conways.testtools.Unit;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:快捷方式 工具列表
 */
public class ShortCutRepository extends BaseRepository {
    /**
     * 快捷列表最大工具数量
     */
    public static final int MAX_SIZE = 3;

    private static final ShortCutRepository ourInstance = new ShortCutRepository();

    public static ShortCutRepository getInstance() {
        return ourInstance;
    }

    private ShortCutRepository() {
        super();
    }

    @Override
    public List<Tool> getTools() {

        tools.clear();
        int[] shortCuts = Unit.getShortCut();

        if (null == shortCuts || shortCuts.length <= 0) {
            tools.add(ToolsFactory.createTool(ToolsFactory.ITINERARY_ID));
            tools.add(ToolsFactory.createTool(ToolsFactory.APPEAL_ID));
            tools.add(ToolsFactory.createTool(ToolsFactory.FEATURES_ID));
        } else {
            for (int i = 0; i < shortCuts.length; i++) {
                tools.add(ToolsFactory.createTool(shortCuts[i]));
            }
        }
        return tools;
    }

    @Override
    public String getTitle() {
        return "首页功能展示";
    }

    /**
     * 添加一个tool到快捷列表
     *
     * @param tool
     */
    public void addTool(Tool tool) {
        if (null == tool) {
            return;
        }
        tools.add(tool);
    }

    /**
     * 从快捷列表移除一个工具
     *
     * @param tool
     */
    public void removeTool(Tool tool) {
        for (Tool item : tools) {
            if (item.getId() == tool.getId()) {
                tools.remove(tool);
                break;
            }
        }
    }

    /**
     * 快捷列表是否已经满
     *
     * @return
     */
    public boolean isFull() {
        return tools.size() >= MAX_SIZE;
    }


    public boolean inShortCut(Tool tool) {
        boolean in = false;
        for (Tool item : tools) {
            if (item.getId() == tool.getId()) {
                in = true;
                break;
            }
        }
        return in;

    }


}
