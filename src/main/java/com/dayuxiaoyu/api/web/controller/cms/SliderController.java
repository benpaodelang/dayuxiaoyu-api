package com.dayuxiaoyu.api.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.service.cms.SliderService;
import com.dayuxiaoyu.api.web.response.BaseListResponse;
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

@RequestMapping("cms/slider")
@Api(tags="幻灯片")
@Controller
public class SliderController {

    @Resource
    private SliderService sliderService;

    /**
     * 列表
     * @param positionId
     * @return
     */
    @RequestMapping("list")
    @ApiOperation(httpMethod = "POST", value = "列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String list(Integer positionId){
        BaseListResponse response = null;
        try {
            response = sliderService.list(positionId);
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }

}
