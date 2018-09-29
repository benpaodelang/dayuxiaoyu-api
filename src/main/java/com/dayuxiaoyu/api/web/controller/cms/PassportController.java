package com.dayuxiaoyu.api.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.service.cms.PassportService;
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
 * @time 2018/1/23 22/03
 * @since
 */

@RequestMapping("cms/passport")
@Api(tags="签证")
@Controller
public class PassportController {

    @Resource
    private PassportService passportService;

    @RequestMapping("positionList")
    @ResponseBody
    public String positionList(Integer positionId){
        BaseListResponse response = null;
        try {
            response = passportService.listByRecommendPositionId(positionId);
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

    @RequestMapping("list")
    @ApiOperation(httpMethod = "POST", value = "列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String list(){

        BaseListResponse response = null;
        try {
            response = passportService.list();
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
            response = passportService.detail(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

}
