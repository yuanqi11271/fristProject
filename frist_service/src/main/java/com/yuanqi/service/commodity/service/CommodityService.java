package com.yuanqi.service.commodity.service;

import com.yuanqi.common.response.BaseResponse;
import com.yuanqi.domain.commdity.Commodity;

import java.util.List;

/**
 * @Author: yq
 * @Date：2019/5/10 13:45
 * @Describe:
 */
public interface CommodityService {

    Commodity insert(Commodity commodity);

    List<Commodity> findAll();

    Commodity findById(Long commodityId);

    BaseResponse delCommodity(Long commodityId);
}
