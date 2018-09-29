package com.dayuxiaoyu.api.service.cms;

import com.dayuxiaoyu.api.dao.cms.RecommendDao;
import com.dayuxiaoyu.api.model.cms.RecommendModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecommendService {

    @Resource
    private RecommendDao recommendDao;

    public List<RecommendModel> selectContentIdsByPositionId(Integer positionId){
        return this.selectAllByPositionId(positionId);
    }

    private List<RecommendModel> selectAllByPositionId(Integer positionId) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("positionId",positionId);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("createTime","1");
        output.put("id","1");
        output.put("positionId","1");
        output.put("orderNum","1");
        output.put("contentId","1");
        return recommendDao.findEntityListByCond(cond,output,null);
    }
}
