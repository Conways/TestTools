package com.conways.testtools.toolsdata.entity;

import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class ToolItem {

    private int id;

    private String title;

    private List<Tool> tools;


    public ToolItem(int id, String title, List<Tool> tools) {
        this.id = id;
        this.title = title;
        this.tools = tools;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Tool> getTools() {
        return tools;
    }

    public void setTools(List<Tool> tools) {
        this.tools = tools;
    }
}
