package com.dayuxiaoyu.api.web.request.cms;

import com.dayuxiaoyu.api.web.request.BaseRequest;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/39
 * @since
 */
public class CategoryListRequest extends BaseRequest {

    private Integer parentId = 0;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
