package com.conways.testtools.toolsdata.entity;

/**
 * @author Zong
 * Created on 2020/6/28
 * Describe:
 */
public class Tool {
    //父id
    private int parentId;
    //id
    private int id;
    //描述
    private String des;
    //描述简称
    private String abbreviation;
    //icon id
    private int icon;
    //icon缩略图id
    private int iconThumb;


    public Tool(int parentId, int id, String des, String abbreviation, int icon, int iconThumb) {
        this.parentId = parentId;
        this.id = id;
        this.des = des;
        this.abbreviation = abbreviation;
        this.icon = icon;
        this.iconThumb = iconThumb;
    }


    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIconThumb() {
        return iconThumb;
    }

    public void setIconThumb(int iconThumb) {
        this.iconThumb = iconThumb;
    }
}
