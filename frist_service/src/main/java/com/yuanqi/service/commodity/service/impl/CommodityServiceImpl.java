package com.yuanqi.service.commodity.service.impl;

import com.yuanqi.common.code.ResultCodeEnum;
import com.yuanqi.common.response.BaseResponse;
import com.yuanqi.datasource.commdity.repository.CommodityRepository;
import com.yuanqi.domain.commdity.Commodity;
import com.yuanqi.service.commodity.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: yq
 * @Date：2019/5/10 13:53
 * @Describe:
 */
@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityRepository commodityRepository;

    @Override
    public Commodity insert(Commodity commodity) {
        commodity.setCommodityId(0L);
        commodity.setCreateTime(new Date());
        commodity.setLastUpdateTime(new Date());
        Commodity save = commodityRepository.save(commodity);
        if (save == null) {
            return null;
        }
        return save;
    }

    @Override
    public List<Commodity> findAll() {
        List<Commodity> all = commodityRepository.findAll();
        if (all.isEmpty()) {
            return null;
        }
        return all;
    }

    @Override
    public Commodity findById(Long commodityId) {
        Optional<Commodity> byId = commodityRepository.findById(commodityId);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public BaseResponse delCommodity(Long commodityId) {
        BaseResponse response = new BaseResponse();
        if (commodityId == null){
            return response.buildFail(ResultCodeEnum.PARAMS_FAIL);
        }
        commodityRepository.deleteById(commodityId);
        return response.buildSuccess();
    }
}
