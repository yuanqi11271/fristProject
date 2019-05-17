package com.yuanqi.service.commodity.controller;

import com.yuanqi.common.response.BaseResponse;
import com.yuanqi.domain.commdity.Commodity;
import com.yuanqi.service.commodity.service.CommodityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: yq
 * @Date：2019/5/8 10:19
 * @Describe: 商品
 */
@RestController
@Api("商品操作")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @PostMapping("/insertCommodity")
    @ApiOperation(value = "商品添加",notes = "增加商品")
    public BaseResponse insertCommodity(@RequestBody Commodity commodity){
        BaseResponse<Commodity> response = new BaseResponse<>();
        return response.buildSuccess(commodityService.insert(commodity));
    }

    @GetMapping("/findAll")
    @ApiOperation(value = "商品列表")
    public BaseResponse findAll(@RequestHeader String userId){
        BaseResponse<List<Commodity>> listBaseResponse = new BaseResponse<>();
        return listBaseResponse.buildSuccess(commodityService.findAll());
    }

    @GetMapping("/findById/{commodityId}")
    @ApiOperation(value = "查询单个商品")
    public BaseResponse findById(@PathVariable Long commodityId){
        BaseResponse<Commodity> response = new BaseResponse<>();
        return response.buildSuccess(commodityService.findById(commodityId));
    }

    @PutMapping("/delCommodity")
    @ApiOperation(value = "删除某个商品")
    public BaseResponse delCommodity(Long commodityId){
        return commodityService.delCommodity(commodityId);
    }
}
