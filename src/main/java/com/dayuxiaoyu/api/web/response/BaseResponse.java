package com.dayuxiaoyu.api.web.response;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.api.common.ResultEnum;

/**
 * @author zyp
 * @version 1.0
 * @time 16/12/20 11/25
 */
public class BaseResponse {

    private Integer resultCode;

    private String resultDesc;

    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public BaseResponse(Integer resultCode, String resultDesc) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
    }

    public BaseResponse(ResultEnum resultEnum) {
        this.resultCode = resultEnum.getResultCode();
        this.resultDesc = resultEnum.getResultDesc();
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
