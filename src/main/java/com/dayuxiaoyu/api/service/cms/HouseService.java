package com.dayuxiaoyu.api.service.cms;

import com.alibaba.fastjson.JSON;
import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.dao.cms.HouseDao;
import com.dayuxiaoyu.api.dao.pagination.PaginationInfo;
import com.dayuxiaoyu.api.dao.pagination.PaginationList;
import com.dayuxiaoyu.api.model.cms.HouseModel;
import com.dayuxiaoyu.api.model.cms.RecommendModel;
import com.dayuxiaoyu.api.web.request.cms.HouseListRequest;
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
public class HouseService {

    @Resource
    private HouseDao houseDao;

    @Resource
    private RecommendService recommendService;

    @Resource
    private CountryService countryService;

    @Resource
    private VideoService videoService;

    /**
     * 列表
     * @param request
     * @return
     */
    public BaseListResponse<HouseModel> list(HouseListRequest request){
        BaseListResponse<HouseModel> response = new BaseListResponse<>(ResultEnum.success);
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("status",1);
        if(request.getCountry()!=null && request.getCountry().trim().length()>0){
            cond.put("country",request.getCountry());
        }
        if(request.getHouseType()!=null && request.getHouseType().trim().length()>0){
            cond.put("houseType",request.getHouseType());
        }
        if(request.getPriceFrom()!=null && request.getPriceFrom()>0){
            cond.put("priceFrom",request.getPriceFrom());
        }
        if(request.getPriceTo()!=null && request.getPriceTo()>0){
            cond.put("priceTo",request.getPriceTo());
        }
        if(request.getPurpose()!=null && request.getPurpose().trim().length()>0){
            cond.put("purpose",request.getPurpose());
        }

        Map<String,Object> output = allColumn();
        PaginationInfo paginationInfo = new PaginationInfo();
        paginationInfo.setRecordPerPage(request.getPageSize());
        paginationInfo.setCurrentPage(request.getPageNo());
        PaginationList<HouseModel> list =  houseDao.findEntityListByCond(cond,output,paginationInfo);

        Map<Integer,String> countryMap = countryService.countryMap();

        for (HouseModel house : list){
            house.setCountryName(countryMap.get(Integer.parseInt(house.getCountry())));
            house.setPictureList(JSON.parseArray(house.getPicture(),String.class));
            house.setPicture(JSON.parseArray(house.getPicture(),String.class).get(0));
            List<Integer> videoIds = JSON.parseArray(house.getVideos(), Integer.class);
            if(videoIds.size()>0){
                house.setVideoList(videoService.selectByIds(videoIds));
            }
        }

        response.setList(list);
        response.setTotalPage(list.getTotalPage());
        response.setCurrentPage(list.getCurrentPage());
        response.setTotalRecord(list.getTotalRecord());
        return response;
    }

    /**
     * 详情
     * @param id
     * @return
     */
    public BaseResponse detail(Integer id){
        BaseResponse response = new BaseResponse(ResultEnum.success);
        Map<Integer,String> countryMap = countryService.countryMap();
        HouseModel houseModel = this.selectByPrimaryKey(id);
        houseModel.setCountryName(countryMap.get(Integer.parseInt(houseModel.getCountry())));

        List<Integer> videoIds = JSON.parseArray(houseModel.getVideos(), Integer.class);
        if(videoIds.size()>0){
            houseModel.setVideoList(videoService.selectByIds(videoIds));
        }
        houseModel.setPictureList(JSON.parseArray(houseModel.getPicture(),String.class));
        houseModel.setPicture(JSON.parseArray(houseModel.getPicture(),String.class).get(0));

        response.setData(houseModel);
        return response;
    }

    public HouseModel selectByPrimaryKey(Integer id) {
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("id",id);
        Map<String,Object> output = allColumn();
        return houseDao.findEntityById(cond,output);
    }

    public BaseListResponse<HouseModel> listByRecommendPositionId(Integer positionId){
        BaseListResponse<HouseModel> response = new BaseListResponse<HouseModel>(ResultEnum.success);
        List<RecommendModel> recommendModels = recommendService.selectContentIdsByPositionId(positionId);
        List<Integer> ids = new ArrayList<>();
        for (RecommendModel recommend : recommendModels) {
            ids.add(recommend.getContentId());
        }
        List<HouseModel> houses = this.selectByIds(ids);
        Map<Integer,HouseModel> houseMap = new HashMap<>();
        for (HouseModel houseModel : houses){
            houseMap.put(houseModel.getId(),houseModel);
        }

        List<HouseModel> resultList = new ArrayList<>();
        for (RecommendModel recommend : recommendModels){
            resultList.add(houseMap.get(recommend.getContentId()));
        }

        Map<Integer,String> countryMap = countryService.countryMap();

        for (HouseModel house : resultList){
            house.setCountryName(countryMap.get(Integer.parseInt(house.getCountry())));
        }

        response.setList(resultList);
        return response;
    }

    public List<HouseModel> selectByIds(List<Integer> ids){
        if(ids.size()<=0){
            return new ArrayList<>();
        }
        Map<String,Object> cond = new HashMap<String,Object>();
        cond.put("inIdList",ids);
        cond.put("status",1);
        Map<String,Object> output = allColumn();

        List<HouseModel> resultList = houseDao.findEntityListByCond(cond,output,null);

        Map<Integer,String> countryMap = countryService.countryMap();

        for (HouseModel house : resultList){
            house.setCountryName(countryMap.get(Integer.parseInt(house.getCountry())));
            house.setPictureList(JSON.parseArray(house.getPicture(),String.class));
            house.setPicture(JSON.parseArray(house.getPicture(),String.class).get(0));
            List<Integer> videoIds = JSON.parseArray(house.getVideos(), Integer.class);
            if(videoIds.size()>0){
                house.setVideoList(videoService.selectByIds(videoIds));
            }
        }

        return resultList;
    }

    private Map<String,Object> allColumn(){
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("picture","1");
        output.put("title","1");
        output.put("description","1");
        output.put("price","1");
        output.put("priceUnit","1");
        output.put("country","1");
        output.put("content","1");
        output.put("region","1");
        output.put("area","1");
        output.put("status","1");
        output.put("floor","1");
        output.put("houseType","1");
        output.put("elevator","1");
        output.put("income","1");
        output.put("huxing","1");
        output.put("id","1");
        output.put("videos","1");
        output.put("createTime","1");
        return output;
    }

}
