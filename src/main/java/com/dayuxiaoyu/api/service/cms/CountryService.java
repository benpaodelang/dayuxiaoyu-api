package com.dayuxiaoyu.api.service.cms;

import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.dao.cms.CountryDao;
import com.dayuxiaoyu.api.model.cms.CountryModel;
import com.dayuxiaoyu.api.web.response.BaseListResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/29 14/15
 * @since
 */

@Service
public class CountryService {

    @Resource
    private CountryDao countryDao;

    public BaseListResponse<CountryModel> list(){
        BaseListResponse<CountryModel> response = new BaseListResponse<>(ResultEnum.success);
        response.setList(this.selectAll());
        return response;
    }

    public Map<Integer,String> countryMap(){
        List<CountryModel> countryModels = this.selectAll();
        Map<Integer,String> map = new HashMap<>();
        for (CountryModel country : countryModels){
            map.put(country.getId(),country.getName());
        }
        return map;
    }

    public List<CountryModel> selectAll() {
        Map<String,Object> cond = new HashMap<String,Object>();
        Map<String,Object> output = new HashMap<String,Object>();
        output.put("parentId","1");
        output.put("name","1");
        output.put("icon","1");
        output.put("orderNum","1");
        output.put("id","1");
        return countryDao.findEntityListByCond(cond,output,null);
    }

}
