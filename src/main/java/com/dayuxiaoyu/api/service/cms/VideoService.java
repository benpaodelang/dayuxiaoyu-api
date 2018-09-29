package com.dayuxiaoyu.api.service.cms;

import com.dayuxiaoyu.api.dao.cms.VideoDao;
import com.dayuxiaoyu.api.model.cms.VideoModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class VideoService {

    @Resource
    private VideoDao videoDao;

    public List<VideoModel> selectByIds(List<Integer> ids){
        if(ids.size()<=0){
            return new ArrayList<>();
        }
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",ids);
        Map<String,Object> output = allColumn();
        return videoDao.findEntityListByCond(cond,output,null);
    }

    private Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("path","1");
        output.put("name","1");
        output.put("image","1");
        output.put("createTime","1");
        output.put("id","1");
        return output;
    }

}
