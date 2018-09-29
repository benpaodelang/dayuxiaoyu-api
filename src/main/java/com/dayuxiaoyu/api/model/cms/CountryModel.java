package com.dayuxiaoyu.api.model.cms;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/29 14/16
 * @since
 */
public class CountryModel {

    private Integer parentId;

    private String name;

    private String icon;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Integer orderNum;

    private Integer id;

    private List<Integer> inIdList;

    private List<CountryModel> children = new ArrayList<CountryModel>();

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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

    public List<CountryModel> getChildren() {
        return children;
    }

    public void setChildren(List<CountryModel> children) {
        this.children = children;
    }
}
