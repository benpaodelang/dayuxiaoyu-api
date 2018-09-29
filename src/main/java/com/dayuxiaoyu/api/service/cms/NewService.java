package com.dayuxiaoyu.api.service.cms;

import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.dao.cms.NewDao;
import com.dayuxiaoyu.api.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.api.dao.pagination.PaginationList;
import com.dayuxiaoyu.api.model.cms.NewModel;
import com.dayuxiaoyu.api.model.cms.RecommendModel;
import com.dayuxiaoyu.api.web.request.cms.NewListRequest;
import com.dayuxiaoyu.api.web.response.BaseListResponse;
import com.dayuxiaoyu.api.web.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class NewService {

    @Resource
    private NewDao newDao;

    @Resource
    private RecommendService recommendService;

    /**
     * 详情
     * @param id
     * @return
     */
    public BaseResponse detail(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(this.selectByPrimaryKey(id));
        return response;
    }

    /**
     * 根据推荐位查询
     * @param positionId
     * @return
     */
    public BaseListResponse<NewModel> listByRecommendPositionId(Integer positionId){
        BaseListResponse<NewModel> response = new BaseListResponse<NewModel>(ResultEnum.success);
        List<RecommendModel> recommendModels = recommendService.selectContentIdsByPositionId(positionId);
        List<Integer> ids = new ArrayList<>();
        for (RecommendModel recommend : recommendModels) {
            ids.add(recommend.getContentId());
        }
        List<NewModel> news = this.selectByIds(ids);
        Map<Integer,NewModel> newMap = new HashMap<>();
        for (NewModel newModel : news){
            newMap.put(newModel.getId(),newModel);
        }

        List<NewModel> resultList = new ArrayList<>();
        for (RecommendModel recommend : recommendModels){
            resultList.add(newMap.get(recommend.getContentId()));
        }
        response.setList(resultList);
        return response;
    }

    /**
     * 列表
     * @param request
     * @return
     */
    public BaseListResponse<NewModel> list(NewListRequest request){
        BaseListResponse<NewModel> response = new BaseListResponse<NewModel>(ResultEnum.success);
        PaginationList<NewModel> list = this.selectWithPage(request.getCategoryId(),request.getPageSize(),request.getPageNo());
        response.setList(list);
        response.setTotalRecord(list.getTotalRecord());
        response.setCurrentPage(list.getCurrentPage());
        response.setTotalPage(list.getTotalPage());
        return response;
    }

    private PaginationList<NewModel> selectWithPage(Integer categoryId,Integer pageSize,Integer pageNo){
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("categoryId",categoryId);
        cond.put("status",1);
        Map<String,Object> output = allColumn();
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(pageSize);
        paginationInfo.setCurrentPage(pageNo);
        return newDao.findEntityListByCond(cond,output,paginationInfo);
    }

    private List<NewModel> selectByIds(List<Integer> ids){
        if(ids.size()<=0){
            return new ArrayList<>();
        }
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",ids);
        cond.put("status",1);
        Map<String,Object> output = allColumn();
        return newDao.findEntityListByCond(cond,output,null);
    }

    private NewModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return newDao.findEntityById(cond,output);
    }

    private Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("createTime","1");
        output.put("description","1");
        output.put("content","1");
        output.put("categoryId","1");
        output.put("thumbnail","1");
        output.put("status","1");
        output.put("id","1");
        return output;
    }

}
