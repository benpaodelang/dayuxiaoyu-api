package com.dayuxiaoyu.api.web.request.cms;

import com.dayuxiaoyu.api.web.request.BaseRequest;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/52
 * @since
 */
public class NewListRequest extends BaseRequest {

    private Integer categoryId = 0;

    private Integer pageSize = 20;

    private Integer pageNo = 0;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
