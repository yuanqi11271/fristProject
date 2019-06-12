package com.yuanqi.service.user.service.impl;

import com.yuanqi.common.response.BaseResponse;
import com.yuanqi.service.user.service.LogonService;
import org.springframework.stereotype.Service;

/**
 * @Author: yq
 * @Date：2019/6/10 11:45
 * @Describe:
 */
@Service
public class LogonServiceImpl implements LogonService {

    @Override
    public BaseResponse logon() {
        BaseResponse<Object> response = new BaseResponse<>();
        String url = "";
        return null;
    }
}
