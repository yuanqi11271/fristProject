package com.yuanqi.common.response;

import com.yuanqi.common.code.ResultCodeEnum;
import lombok.Data;

/**
 * @Auther: yq
 * @Date：2019/4/18 16:01
 */
@Data
public class BaseResponse<T> {

    String resultCode;
    String resultMsg;
    T resultData;

    public BaseResponse<T> buildSuccess(){
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
        this.resultData = null;
        this.resultMsg = ResultCodeEnum.SUCCESS.getDesc();
        return this;
    }

    public BaseResponse<T> buildSuccess(T resultData){
        this.resultData = resultData;
        this.resultCode = ResultCodeEnum.SUCCESS.getCode();
        this.resultMsg = ResultCodeEnum.SUCCESS.getDesc();
        return this;
    }

    public BaseResponse<T> buildFail(){
        this.resultCode = ResultCodeEnum.FAIL.getCode();
        this.resultData = null;
        this.resultMsg = ResultCodeEnum.FAIL.getDesc();
        return this;
    }

    public BaseResponse<T> buildFail(ResultCodeEnum code){
        this.resultCode = code.getCode();
        this.resultData = null;
        this.resultMsg = code.getDesc();
        return this;
    }
}
