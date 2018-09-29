package com.dayuxiaoyu.api.model.cms;

import java.sql.Timestamp;
import java.util.List;

public class AdvisoryModel {
    private String country;

    private String name;

    private String phone;

    private Timestamp createTime;

    private Timestamp createTimeUp;

    private Timestamp createTimeDown;

    private Integer status;

    private String immigrationRequest;

    private String timeRequest;

    private String businessExperience;

    private String priceRequest;

    private String overseasExperience;

    private String riskTolerance;

    private Integer id;

    private List<Integer> inIdList;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getImmigrationRequest() {
        return immigrationRequest;
    }

    public void setImmigrationRequest(String immigrationRequest) {
        this.immigrationRequest = immigrationRequest;
    }

    public String getTimeRequest() {
        return timeRequest;
    }

    public void setTimeRequest(String timeRequest) {
        this.timeRequest = timeRequest;
    }

    public String getBusinessExperience() {
        return businessExperience;
    }

    public void setBusinessExperience(String businessExperience) {
        this.businessExperience = businessExperience;
    }

    public String getPriceRequest() {
        return priceRequest;
    }

    public void setPriceRequest(String priceRequest) {
        this.priceRequest = priceRequest;
    }

    public String getOverseasExperience() {
        return overseasExperience;
    }

    public void setOverseasExperience(String overseasExperience) {
        this.overseasExperience = overseasExperience;
    }

    public String getRiskTolerance() {
        return riskTolerance;
    }

    public void setRiskTolerance(String riskTolerance) {
        this.riskTolerance = riskTolerance;
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
