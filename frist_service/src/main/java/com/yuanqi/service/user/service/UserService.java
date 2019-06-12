package com.yuanqi.service.user.service;

import com.yuanqi.common.request.user.UserCreateRequest;
import com.yuanqi.common.response.BaseResponse;

/**
 * @Author: yq
 * @Date：2019/4/18 17:02
 */
public interface UserService {
    BaseResponse insertUser(UserCreateRequest request);

    BaseResponse findUserAll();

    BaseResponse findUser(String userId);

    BaseResponse<Object> logon();
}
