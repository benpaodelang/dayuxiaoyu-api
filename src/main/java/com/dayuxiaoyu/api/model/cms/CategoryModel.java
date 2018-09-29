package com.dayuxiaoyu.api.model.cms;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CategoryModel {

    private Integer parentId;

    private String name;

    private String icon;

    private Integer type;

    private Integer display;

    private String path;

    private Timestamp createTime;

    private Timestamp createTimeUp;

    private Timestamp createTimeDown;

    private Timestamp updateTime;

    private Integer orderNum;

    private Integer id;

    private String content;

    private List<Integer> inIdList;

    private List<CategoryModel> children = new ArrayList<CategoryModel>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<CategoryModel> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryModel> children) {
        this.children = children;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getCreateTimeUp() {
        return createTimeUp;
    }

    public void setCreateTimeUp(Timestamp createTimeUp) {
        this.createTimeUp = createTimeUp;
    }

    public Timestamp getCreateTimeDown() {
        return createTimeDown;
    }

    public void setCreateTimeDown(Timestamp createTimeDown) {
        this.createTimeDown = createTimeDown;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Integer> getInIdList() {
        return inIdList;
    }

    public void setInIdList(List<Integer> inIdList) {
        this.inIdList = inIdList;
    }
}
