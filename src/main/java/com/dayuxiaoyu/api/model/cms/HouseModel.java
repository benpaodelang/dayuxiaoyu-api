package com.dayuxiaoyu.api.model.cms;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HouseModel {

    private String titleLike;

    private String picture;

    private String videos;

    private String title;

    private String description;

    private Integer price;

    private String priceUnit;

    private String country;

    private String countryName;

    private String content;

    private String region;

    private String area;

    private Integer floor;

    private String houseType;

    private Integer elevator;

    private BigDecimal income;

    private Integer status;

    private String huxing;

    private Integer id;

    private Timestamp createTime;

    private List<String> pictureList = new ArrayList<>();

    private List<VideoModel> videoList = new ArrayList<>();

    public List<String> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<String> pictureList) {
        this.pictureList = pictureList;
    }

    private List<Integer> inIdList;

    public List<VideoModel> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<VideoModel> videoList) {
        this.videoList = videoList;
    }

    public String getVideos() {
        return videos;
    }

    public void setVideos(String videos) {
        this.videos = videos;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTitleLike() {
        return titleLike;
    }

    public void setTitleLike(String titleLike) {
        this.titleLike = titleLike;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(String priceUnit) {
        this.priceUnit = priceUnit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getElevator() {
        return elevator;
    }

    public void setElevator(Integer elevator) {
        this.elevator = elevator;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getHuxing() {
        return huxing;
    }

    public void setHuxing(String huxing) {
        this.huxing = huxing;
    }
}
