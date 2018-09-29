package com.dayuxiaoyu.api.model.cms;

import com.alibaba.fastjson.JSONArray;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ImmigrationModel {

    private String title;

    private String picture;

    private String subTitle;

    private String description;

    private String country;

    private String priceDetail;

    private String projectBenefits;

    private String applicationProcess;

    private String applicationCondition;

    private String countryInstroduction;

    private String successCase;

    private String price;

    private String period;

    private String identityType;

    private String livingRequirement;

    private String criminalRecord;

    private Timestamp createTime;

    private Integer orderNum;

    private Integer id;

    private Integer status;

    private List<Integer> inIdList;

    private JSONArray relatedHouse = new JSONArray();

    private String videos = "[]";

    private String houses = "[]";

    private List<HouseModel> recommendHouse = new ArrayList<>();

    private List<VideoModel> videoList = new ArrayList<>();

    public List<VideoModel> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoModel> videoList) {
        this.videoList = videoList;
    }

    public List<HouseModel> getRecommendHouse() {
        return recommendHouse;
    }

    public void setRecommendHouse(List<HouseModel> recommendHouse) {
        this.recommendHouse = recommendHouse;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getHouses() {
        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

    public JSONArray getRelatedHouse() {
        return relatedHouse;
    }

    public void setRelatedHouse(JSONArray relatedHouse) {
        this.relatedHouse = relatedHouse;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPriceDetail() {
        return priceDetail;
    }

    public void setPriceDetail(String priceDetail) {
        this.priceDetail = priceDetail;
    }

    public String getProjectBenefits() {
        return projectBenefits;
    }

    public void setProjectBenefits(String projectBenefits) {
        this.projectBenefits = projectBenefits;
    }

    public String getApplicationProcess() {
        return applicationProcess;
    }

    public void setApplicationProcess(String applicationProcess) {
        this.applicationProcess = applicationProcess;
    }

    public String getApplicationCondition() {
        return applicationCondition;
    }

    public void setApplicationCondition(String applicationCondition) {
        this.applicationCondition = applicationCondition;
    }

    public String getCountryInstroduction() {
        return countryInstroduction;
    }

    public void setCountryInstroduction(String countryInstroduction) {
        this.countryInstroduction = countryInstroduction;
    }

    public String getSuccessCase() {
        return successCase;
    }

    public void setSuccessCase(String successCase) {
        this.successCase = successCase;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getLivingRequirement() {
        return livingRequirement;
    }

    public void setLivingRequirement(String livingRequirement) {
        this.livingRequirement = livingRequirement;
    }

    public String getCriminalRecord() {
        return criminalRecord;
    }

    public void setCriminalRecord(String criminalRecord) {
        this.criminalRecord = criminalRecord;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
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
