package com.dayuxiaoyu.api.web.request.cms;

import com.dayuxiaoyu.api.web.request.BaseRequest;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 23/21
 * @since
 */
public class HouseListRequest extends BaseRequest {

    private Integer pageSize = 20;

    private Integer pageNo = 0;

    private String country;

    private String houseType;

    private Integer priceFrom;

    private Integer priceTo;

    private String purpose;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(Integer priceFrom) {
        this.priceFrom = priceFrom;
    }

    public Integer getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(Integer priceTo) {
        this.priceTo = priceTo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
