package com.dayuxiaoyu.api.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.service.cms.AdvisoryService;
import com.dayuxiaoyu.api.util.ValidationResult;
import com.dayuxiaoyu.api.web.request.cms.AddAdvisoryRequest;
import com.dayuxiaoyu.api.web.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/01
 * @since
 */

@RequestMapping("cms/advisory")
@Controller
@Api(tags="咨询")
public class AdvisoryController {

    @Resource
    private AdvisoryService advisoryService;

    /**
     * 提交咨询
     * @param request
     * @return
     */
    @RequestMapping(value="add",method= RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "提交", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String add(AddAdvisoryRequest request) {
        BaseResponse response = null;
        try {
            ValidationResult validateResult = request.validate();
            if(validateResult.isHasErrors()){
                response = new BaseResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = advisoryService.add(request);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

}
