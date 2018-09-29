package com.dayuxiaoyu.api.web.request;

import com.dayuxiaoyu.api.util.ValidationResult;
import com.dayuxiaoyu.api.util.ValidationUtils;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/22 18/51
 * @since
 */
public class BaseRequest {

    public ValidationResult validate(){
        return ValidationUtils.validateEntity(this);
    }

}
