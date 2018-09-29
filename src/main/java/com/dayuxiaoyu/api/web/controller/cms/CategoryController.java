package com.dayuxiaoyu.api.web.controller.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.service.cms.CategoryService;
import com.dayuxiaoyu.api.util.ValidationResult;
import com.dayuxiaoyu.api.web.request.cms.CategoryListRequest;
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
 * @time 2018/1/23 22/01
 * @since
 */

@RequestMapping("cms/category")
@Api(tags="栏目")
@Controller
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 栏目列表
     * @param request
     * @return
     */
    @RequestMapping("list")
    @ApiOperation(httpMethod = "GET", value = "列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String list(CategoryListRequest request){

        BaseListResponse response = null;
        try {
            ValidationResult validateResult = request.validate();
            if(validateResult.isHasErrors()){
                response = new BaseListResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = categoryService.list(request);
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
    @RequestMapping("treeList")
    @ApiOperation(httpMethod = "GET", value = "树列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String treeList(CategoryListRequest request){

        BaseListResponse response = null;
        try {
            ValidationResult validateResult = request.validate();
            if(validateResult.isHasErrors()){
                response = new BaseListResponse(ResultEnum.validFail);
                response.setResultDesc(validateResult.toString());
                return JSON.toJSONString(response);
            }
            response = categoryService.treeList(request);
        } catch (Exception e){
            response = new BaseListResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);

    }

    /**
     * 详情
     * @param id
     * @return
     */
    @RequestMapping("detail")
    @ResponseBody
    public String detail(Integer id){
        BaseResponse response = null;
        try {
            response = categoryService.detail(id);
        } catch (Exception e){
            response = new BaseResponse(ResultEnum.systemFail);
        }
        return JSON.toJSONString(response);
    }


}
