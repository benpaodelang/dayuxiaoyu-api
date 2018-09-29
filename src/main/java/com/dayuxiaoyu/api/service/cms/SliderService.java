package com.dayuxiaoyu.api.service.cms;

import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.dao.cms.SliderDao;
import com.dayuxiaoyu.api.model.cms.SliderModel;
import com.dayuxiaoyu.api.web.response.BaseListResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/08
 * @since
 */

@Service
public class SliderService {

    @Resource
    private SliderDao sliderDao;

    /**
     * 列表
     * @param positionId
     * @return
     */
    public BaseListResponse<SliderModel> list(Integer positionId){
        BaseListResponse<SliderModel> response = new BaseListResponse<>(ResultEnum.success);
        response.setList(this.selectByPosition(positionId));
        return response;
    }

    public List<SliderModel> selectByPosition(Integer position) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("positionId",position);
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("image","1");
        output.put("title","1");
        output.put("url","1");
        output.put("orderNum","1");
        output.put("positionId","1");
        output.put("id","1");
        return sliderDao.findEntityListByCond(cond,output,null);
    }

}
