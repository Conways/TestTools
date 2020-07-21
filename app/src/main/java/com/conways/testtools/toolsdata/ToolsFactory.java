package com.conways.testtools.toolsdata;

import com.conways.testtools.R;
import com.conways.testtools.toolsdata.entity.Tool;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class ToolsFactory {
    //快捷方式
    public static final int SHORTCUT = 999;
    //常用功能
    public static final int COMMON_FUNCTION = 10000;
    //接单助手
    public static final int ORDER_ASSISTANT = 10001;
    //活动政策
    public static final int ACTIVITY_POLICY = 10002;
    //司机服务
    public static final int DRIVER_SERVER = 10003;


    public static final int ITINERARY_ID = 0;

    public static final int LISTENINGTEST_ID = 1;
    public static final int HEATMAP_ID = 2;
    public static final int ORDERSETTING_ID = 3;

    public static final int POLICY_ID = 4;
    public static final int REWARD_ID = 5;

    public static final int ELECTRICPILE_ID = 6;
    public static final int TOILET_ID = 7;
    public static final int FEATURES_ID = 8;
    public static final int APPEAL_ID = 9;
    public static final int DRIVERSCHOOL_ID = 10;
    public static final int OPERATINGAREA_ID = 11;
    public static final int SHIFT_ID = 12;


    /*----------------常用功能-----------*/
    //行程
    private static Tool itinerary;


    /*----------------接单助手-----------*/
    //听单检测
    private static Tool listeningTest;
    //热力图
    private static Tool heatMap;
    //接单设置
    private static Tool OrderSetting;

    /*---------------活动政策-----------*/
    //政策
    private static Tool policy;
    //奖励
    private static Tool reward;


    /*---------------司机服务-----------*/
    //电桩
    private static Tool electricPile;
    //找厕所
    private static Tool toilet;
    //功能介绍
    private static Tool features;
    //申诉中心
    private static Tool appeal;
    //司机学院
    private static Tool driverSchool;
    //运营区域
    private static Tool operatingArea;
    //双班司机
    private static Tool shift;


    /**
     * 根据父类id获取父类下的所有工具
     *
     * @param id
     * @param isShift 是不是双班司机
     * @return
     */
    public static List<Tool> createTools(int id, boolean isShift) {

        List<Tool> tools = new ArrayList<>();
        switch (id) {
            case COMMON_FUNCTION:
                tools.add(itinerary);
                break;
            case ORDER_ASSISTANT:
                tools.add(listeningTest);
                tools.add(heatMap);
                tools.add(OrderSetting);
                break;
            case ACTIVITY_POLICY:
                tools.add(policy);
                tools.add(reward);
                break;
            case DRIVER_SERVER:
                tools.add(electricPile);
                tools.add(toilet);
                tools.add(features);
                tools.add(appeal);
                tools.add(driverSchool);
                tools.add(operatingArea);
                if (isShift) {
                    tools.add(shift);
                }
                break;
            default:
                break;
        }
        return tools;
    }

    /**
     * 根据父类id获取父类下的所有工具
     *
     * @param id
     * @return
     */
    public static List<Tool> createTools(int id) {
        return createTools(id, false);
    }

    /**
     * 根据id查询Tool
     * @param id
     * @return
     */

    public static Tool createTool(int id) {

        Tool tool = null;

        switch (id) {
            case ITINERARY_ID:
                tool=itinerary;
                break;
            case LISTENINGTEST_ID:
                tool=listeningTest;
                break;
            case HEATMAP_ID:
                tool=heatMap;
                break;
            case ORDERSETTING_ID:
                tool=OrderSetting;
                break;
            case POLICY_ID:
                tool=policy;
                break;
            case REWARD_ID:
                tool=reward;
                break;
            case ELECTRICPILE_ID:
                tool=electricPile;
                break;
            case TOILET_ID:
                tool=toilet;
                break;
            case FEATURES_ID:
                tool=features;
                break;
            case APPEAL_ID:
                tool=appeal;
                break;
            case DRIVERSCHOOL_ID:
                tool=driverSchool;
                break;
            case OPERATINGAREA_ID:
                tool=operatingArea;
                break;
            case SHIFT_ID:
                tool=shift;
                break;

            default:
                break;


        }


        return tool;

    }


    static {

        itinerary = new Tool(COMMON_FUNCTION, ITINERARY_ID, "行程", "行程", R.mipmap.ic_launcher,R.mipmap.ic_launcher);

        listeningTest = new Tool(ORDER_ASSISTANT, LISTENINGTEST_ID, "听单检测", "听单", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        heatMap = new Tool(ORDER_ASSISTANT, HEATMAP_ID, "热力图", "热力图", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        OrderSetting = new Tool(ORDER_ASSISTANT, ORDERSETTING_ID, "接单设置", "接单", R.mipmap.ic_launcher,R.mipmap.ic_launcher);

        policy = new Tool(ACTIVITY_POLICY, POLICY_ID, "政策", "政策", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        reward = new Tool(ACTIVITY_POLICY, REWARD_ID, "奖励", "奖励", R.mipmap.ic_launcher,R.mipmap.ic_launcher);

        electricPile = new Tool(DRIVER_SERVER, ELECTRICPILE_ID, "电桩", "电桩", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        toilet = new Tool(DRIVER_SERVER, TOILET_ID, "找厕所", "找厕所", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        features = new Tool(DRIVER_SERVER, FEATURES_ID, "功能介绍", "功能", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        appeal = new Tool(DRIVER_SERVER, APPEAL_ID, "申诉中心", "申诉", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        driverSchool = new Tool(DRIVER_SERVER, DRIVERSCHOOL_ID, "司机学院", "学院", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        operatingArea = new Tool(DRIVER_SERVER, OPERATINGAREA_ID, "运营区域", "区域", R.mipmap.ic_launcher,R.mipmap.ic_launcher);
        shift = new Tool(DRIVER_SERVER, SHIFT_ID, "双班司机", "双班", R.mipmap.ic_launcher,R.mipmap.ic_launcher);

    }


}
