package com.yuanqi.common.code;

import lombok.Getter;

/**
 * @Author: yq
 * @Date：2019/4/18 16:10
 */
public enum  ResultCodeEnum {
    SUCCESS("0000","请求成功"),
    FAIL("0010","请求失败"),
    PARAMS_FAIL("0011","参数异常");
    ResultCodeEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    @Getter
    private String code;
    @Getter
    private String desc;

}
