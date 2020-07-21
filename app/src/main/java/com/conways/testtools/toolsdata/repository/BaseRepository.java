package com.conways.testtools.toolsdata.repository;

import com.conways.testtools.toolsdata.entity.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public abstract class BaseRepository {

    protected ArrayList<Tool> tools;


    public BaseRepository() {
        tools=new ArrayList<>();
    }


    public abstract List<Tool> getTools();


    public abstract String getTitle();



}
