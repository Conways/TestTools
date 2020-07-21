package com.conways.testtools.toolsdata.repository;

import com.conways.testtools.toolsdata.ToolsFactory;
import com.conways.testtools.toolsdata.entity.Tool;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class CommonFunctionRepository extends BaseRepository{
    private static final CommonFunctionRepository ourInstance = new CommonFunctionRepository();

    public static CommonFunctionRepository getInstance() {
        return ourInstance;
    }

    private CommonFunctionRepository() {
        super();
    }

    @Override
    public List<Tool> getTools() {
        tools.clear();
        tools.addAll(ToolsFactory.createTools(ToolsFactory.COMMON_FUNCTION));
        return tools;
    }


    @Override
    public String getTitle() {
        return "常用功能";
    }


}
