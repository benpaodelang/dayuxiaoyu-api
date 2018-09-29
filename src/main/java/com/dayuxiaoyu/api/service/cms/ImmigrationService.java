package com.dayuxiaoyu.api.service.cms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.dao.cms.ImmigrationDao;
import com.dayuxiaoyu.api.model.cms.ImmigrationModel;
import com.dayuxiaoyu.api.model.cms.RecommendModel;
import com.dayuxiaoyu.api.web.response.BaseListResponse;
import com.dayuxiaoyu.api.web.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/07
 * @since
 */

@Service
public class ImmigrationService {

    @Resource
    private HouseService houseService;

    @Resource
    private VideoService videoService;

    @Resource
    private ImmigrationDao immigrationDao;

    @Resource
    private RecommendService recommendService;

    public BaseResponse detail(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        ImmigrationModel immigrationModel = this.selectByPrimaryKey(id);

        // 获取关联房产
        String houses = immigrationModel.getHouses();
        List<Integer> houseIds = new ArrayList<>();
        Iterator<Object> houseIterator = JSON.parseArray(houses).iterator();
        while (houseIterator.hasNext()){
            JSONObject house = (JSONObject) houseIterator.next();
            houseIds.add(house.getIntValue("id"));
        }
        if(houseIds.size()>0){
            immigrationModel.setRecommendHouse(houseService.selectByIds(houseIds));
        }

        // 获取关联视频
        String videos = immigrationModel.getVideos();
        List<Integer> videoIds = new ArrayList<>();
        Iterator<Object> videoIterator = JSON.parseArray(videos).iterator();
        while (videoIterator.hasNext()){
            JSONObject video = (JSONObject) videoIterator.next();
            videoIds.add(video.getIntValue("id"));
        }
        if(videoIds.size()>0){
            immigrationModel.setVideoList(videoService.selectByIds(videoIds));
        }

        response.setData(immigrationModel);
        return response;
    }

    public BaseListResponse<ImmigrationModel> list(){
        BaseListResponse<ImmigrationModel> response = new BaseListResponse<>(ResultEnum.success);
        response.setList(this.selectAll());
        return response;
    }

    /**
     * 根据推荐位查询
     * @param positionId
     * @return
     */
    public BaseListResponse<ImmigrationModel> listByRecommendPositionId(Integer positionId){
        BaseListResponse<ImmigrationModel> response = new BaseListResponse<ImmigrationModel>(ResultEnum.success);
        List<RecommendModel> recommendModels = recommendService.selectContentIdsByPositionId(positionId);
        List<Integer> ids = new ArrayList<>();
        for (RecommendModel recommend : recommendModels) {
            ids.add(recommend.getContentId());
        }
        List<ImmigrationModel> immigrations = this.selectByIds(ids);
        Map<Integer,ImmigrationModel> immigrationMap = new HashMap<>();
        for (ImmigrationModel immigrationModel : immigrations){
            immigrationMap.put(immigrationModel.getId(),immigrationModel);
        }

        List<ImmigrationModel> resultList = new ArrayList<>();
        for (RecommendModel recommend : recommendModels){
            resultList.add(immigrationMap.get(recommend.getContentId()));
        }
        response.setList(resultList);
        return response;
    }

    private List<ImmigrationModel> selectByIds(List<Integer> ids) {
        if(ids.size()<=0){
            return new ArrayList<>();
        }
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",ids);
        cond.put("status",1);
        Map<String,Object> output = allColumn();
        return immigrationDao.findEntityListByCond(cond,output,null);
    }

    private List<ImmigrationModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("status",1);
        Map<String,Object> output = allColumn();
        return immigrationDao.findEntityListByCond(cond,output,null);
    }

    private ImmigrationModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return immigrationDao.findEntityById(cond,output);
    }

    private Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("title","1");
        output.put("picture","1");
        output.put("priceDetail","1");
        output.put("projectBenefits","1");
        output.put("applicationProcess","1");
        output.put("applicationCondition","1");
        output.put("countryInstroduction","1");
        output.put("successCase","1");
        output.put("price","1");
        output.put("period","1");
        output.put("status","1");
        output.put("videos","1");
        output.put("houses","1");
        output.put("identityType","1");
        output.put("livingRequirement","1");
        output.put("criminalRecord","1");
        output.put("createTime","1");
        output.put("orderNum","1");
        output.put("subTitle","1");
        output.put("description","1");
        output.put("country","1");
        output.put("id","1");
        return output;
    }

}
