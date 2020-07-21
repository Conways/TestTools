package com.conways.testtools.toolsdata.repository;

import com.conways.testtools.toolsdata.ToolsFactory;
import com.conways.testtools.Unit;
import com.conways.testtools.toolsdata.entity.Tool;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class DriverServerRepository extends BaseRepository{
    private static final DriverServerRepository ourInstance = new DriverServerRepository();

    public static DriverServerRepository getInstance() {
        return ourInstance;
    }

    private DriverServerRepository() {
        super();
    }

    @Override
    public List<Tool> getTools() {
        tools.clear();
        tools.addAll(ToolsFactory.createTools(ToolsFactory.DRIVER_SERVER, true));
        return tools;
    }


    @Override
    public String getTitle() {
        return "司机服务";
    }
}
