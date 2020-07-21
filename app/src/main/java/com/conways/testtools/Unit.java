package com.conways.testtools;

import com.conways.testtools.toolsdata.ToolsFactory;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class Unit {


    private Unit() {


    }


    public static boolean isShirft() {

        return (100 * Math.random()) % 2 == 0;

    }


    public static int[] getShortCut() {

        int[] shortCut = {ToolsFactory.ITINERARY_ID, ToolsFactory.POLICY_ID, ToolsFactory.APPEAL_ID};
        if ((100 * Math.random()) % 2 == 0) {
            return shortCut;
        }
        return null;
    }
}
