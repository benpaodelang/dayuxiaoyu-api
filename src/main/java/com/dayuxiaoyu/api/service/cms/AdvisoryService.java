package com.dayuxiaoyu.api.service.cms;

import com.dayuxiaoyu.api.common.ResultEnum;
import com.dayuxiaoyu.api.dao.cms.AdvisoryDao;
import com.dayuxiaoyu.api.model.cms.AdvisoryModel;
import com.dayuxiaoyu.api.web.request.cms.AddAdvisoryRequest;
import com.dayuxiaoyu.api.web.response.BaseResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zyp
 * @version 1.0
 * @time 2018/1/23 22/07
 * @since
 */

@Service
public class AdvisoryService {

    @Resource
    private AdvisoryDao advisoryDao;

    /**
     * 添加
     * @param request
     * @return
     */
    public BaseResponse add(AddAdvisoryRequest request) {

        AdvisoryModel advisoryModel= new AdvisoryModel();
        advisoryModel.setCountry(request.getAdvisoryCountry());
        advisoryModel.setName(request.getAdvisoryName());
        advisoryModel.setPhone(request.getAdvisoryPhone());
        advisoryModel.setImmigrationRequest(request.getAdvisoryImmigrationRequest());
        advisoryModel.setTimeRequest(request.getAdvisoryTimeRequest());
        advisoryModel.setBusinessExperience(request.getAdvisoryBusinessExperience());
        advisoryModel.setPriceRequest(request.getAdvisoryPriceRequest());
        advisoryModel.setOverseasExperience(request.getAdvisoryOverseasExperience());
        advisoryModel.setRiskTolerance(request.getAdvisoryRiskTolerance());

        AdvisoryModel result = this.insert(advisoryModel);

        BaseResponse response = new BaseResponse(ResultEnum.success);
        response.setData(result);
        return response;
    }

    public AdvisoryModel insert(AdvisoryModel advisoryModel) {
        return advisoryDao.addEntity(advisoryModel);
    }

}
