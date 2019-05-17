package com.yuanqi.common.request.commodity;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @Author: yq
 * @Date：2019/5/16 11:49
 * @Describe:
 */
@Data
public class CommodityCreateRequest {


    @ApiParam("商品id")
    String commodityId;

    @NotNull
    @ApiParam("商品名称")
    String commodityName;

    @NotNull
    @ApiParam("商品类型")
    String type;

    @NotNull
    @ApiParam("商品单价")
    String commodityPrice;

    @NotNull
    @ApiParam("商品数量")
    String commodityNum;


}
