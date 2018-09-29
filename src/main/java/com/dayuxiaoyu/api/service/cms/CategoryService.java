package com.dayuxiaoyu.api.service.cms;

import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.dao.cms.CategoryDao;
import com.dayuxiaoyu.api.model.cms.CategoryModel;
import com.dayuxiaoyu.api.web.request.cms.CategoryListRequest;
import com.dayuxiaoyu.api.web.response.BaseListResponse;
import com.dayuxiaoyu.api.web.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/07
 * @since
 */

@Service
public class CategoryService {

    @Resource
    private CategoryDao categoryDao;

    /**
     * 栏目列表
     * @param request
     * @return
     */
    public BaseListResponse<CategoryModel> list(CategoryListRequest request){
        BaseListResponse<CategoryModel> response = new BaseListResponse<>(ResultEnum.success);
        response.setList(this.selectByParentId(request.getParentId()));
        return response;
    }

    /**
     * 栏目树
     * @param request
     * @return
     */
    public BaseListResponse<CategoryModel> treeList(CategoryListRequest request){
        BaseListResponse<CategoryModel> response = new BaseListResponse<>(ResultEnum.success);
        response.setList(this.buildTree(request.getParentId()));
        return response;
    }

    /**
     * 根据栏目Id查询
     * @param parentId
     * @return
     */
    private List<CategoryModel> selectByParentId(Integer parentId){
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("parentId",parentId);
        cond.put("display",1);
        Map<String,Object> output = this.allColumn();
        return categoryDao.findEntityListByCond(cond,output,null);
    }

    public BaseResponse detail(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        CategoryModel category = categoryDao.findEntityById(cond,this.allColumn());
        response.setData(category);
        return response;
    }

    /**
     * 构建tree
     * @param parentId
     * @return
     */
    private List<CategoryModel> buildTree(Integer parentId){
        List<CategoryModel> categorys = this.selectByParentId(parentId);
        for (CategoryModel category : categorys){
            category.setChildren(this.buildTree(category.getId()));
        }
        return categorys;
    }

    private Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("parentId","1");
        output.put("name","1");
        output.put("icon","1");
        output.put("type","1");
        output.put("display","1");
        output.put("path","1");
        output.put("createTime","1");
        output.put("updateTime","1");
        output.put("orderNum","1");
        output.put("id","1");
        output.put("content","1");
        return output;
    }

}
