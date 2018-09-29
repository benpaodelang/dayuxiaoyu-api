package com.dayuxiaoyu.api.web.request.cms;

import com.dayuxiaoyu.api.web.request.BaseRequest;
import io.swagger.annotations.ApiParam;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/17
 * @since
 */
public class AddAdvisoryRequest extends BaseRequest {

    @NotNull
    @ApiParam(value="意向国家",required=true)
    private String advisoryCountry;

    @NotNull
    @ApiParam(value="客户姓名",required=true)
    private String advisoryName;

    @NotNull
    @ApiParam(value="客户电话",required=true)
    private String advisoryPhone;

    @ApiParam(value="移民需求",required=true)
    private String advisoryImmigrationRequest;

    @ApiParam(value="时间要求",required=true)
    private String advisoryTimeRequest;

    @ApiParam(value="经商经验",required=true)
    private String advisoryBusinessExperience;

    @ApiParam(value="投资额度",required=true)
    private String advisoryPriceRequest;

    @ApiParam(value="海外经验",required=true)
    private String advisoryOverseasExperience;

    @ApiParam(value="风险经受能力",required=true)
    private String advisoryRiskTolerance;

    public String getAdvisoryCountry() {
        return advisoryCountry;
    }

    public void setAdvisoryCountry(String advisoryCountry) {
        this.advisoryCountry = advisoryCountry;
    }

    public String getAdvisoryName() {
        return advisoryName;
    }

    public void setAdvisoryName(String advisoryName) {
        this.advisoryName = advisoryName;
    }

    public String getAdvisoryPhone() {
        return advisoryPhone;
    }

    public void setAdvisoryPhone(String advisoryPhone) {
        this.advisoryPhone = advisoryPhone;
    }

    public String getAdvisoryImmigrationRequest() {
        return advisoryImmigrationRequest;
    }

    public void setAdvisoryImmigrationRequest(String advisoryImmigrationRequest) {
        this.advisoryImmigrationRequest = advisoryImmigrationRequest;
    }

    public String getAdvisoryTimeRequest() {
        return advisoryTimeRequest;
    }

    public void setAdvisoryTimeRequest(String advisoryTimeRequest) {
        this.advisoryTimeRequest = advisoryTimeRequest;
    }

    public String getAdvisoryBusinessExperience() {
        return advisoryBusinessExperience;
    }

    public void setAdvisoryBusinessExperience(String advisoryBusinessExperience) {
        this.advisoryBusinessExperience = advisoryBusinessExperience;
    }

    public String getAdvisoryPriceRequest() {
        return advisoryPriceRequest;
    }

    public void setAdvisoryPriceRequest(String advisoryPriceRequest) {
        this.advisoryPriceRequest = advisoryPriceRequest;
    }

    public String getAdvisoryOverseasExperience() {
        return advisoryOverseasExperience;
    }

    public void setAdvisoryOverseasExperience(String advisoryOverseasExperience) {
        this.advisoryOverseasExperience = advisoryOverseasExperience;
    }

    public String getAdvisoryRiskTolerance() {
        return advisoryRiskTolerance;
    }

    public void setAdvisoryRiskTolerance(String advisoryRiskTolerance) {
        this.advisoryRiskTolerance = advisoryRiskTolerance;
    }
}
