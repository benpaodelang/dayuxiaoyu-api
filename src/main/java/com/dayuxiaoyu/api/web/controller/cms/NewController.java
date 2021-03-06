package com.dayuxiaoyu.api.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.service.cms.NewService;
import com.dayuxiaoyu.api.util.ValidationResult;
import com.dayuxiaoyu.api.web.request.cms.NewListRequest;
import com.dayuxiaoyu.api.web.response.BaseListResponse;
import com.dayuxiaoyu.api.web.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/02
 * @since
 */

@RequestMapping("cms/new")
@Api(tags="新闻")
@Controller
public class NewController {

    @Resource
    private NewService newService;

    @RequestMapping("positionList")
    @ResponseBody
    public String positionList(Integer positionId){
        BaseListResponse response = null;
        try {
            response = newService.listByRecommendPositionId(positionId);
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    /**
     * 栏目列表
     * @param request
     * @return
     */
    @RequestMapping("list")
    @ApiOperation(httpMethod = "POST", value = "列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String list(NewListRequest request){
        BaseListResponse response = null;
        try {
            ValidationResult validateResult = request.validate();
            if(validateResult.isHasErrors()){
                response = new BaseListResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = newService.list(request);
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("detail")
    @ApiOperation(httpMethod = "GET", value = "详情", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String detail(Integer id){

        BaseResponse response = null;
        try {
            response = newService.detail(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }


}
