package com.yuanqi.service.user.service.impl;

import com.yuanqi.common.code.ResultCodeEnum;
import com.yuanqi.common.request.user.UserCreateRequest;
import com.yuanqi.common.response.BaseResponse;
import com.yuanqi.datasource.user.dao.repository.UserRepository;
import com.yuanqi.domain.user.User;
import com.yuanqi.service.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: yq
 * @Date：2019/4/18 17:03
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public BaseResponse insertUser(UserCreateRequest request) {
        BaseResponse response = new BaseResponse<>();
        if (request == null){
            log.error("插入用户操作-失败-参数为空，request：{}",request);
            return response.buildFail(ResultCodeEnum.PARAMS_FAIL);
        }
        request.setCustomerId("");
        User user = new User();
        Date date = new Date();
        user.setCreateTime(date);
        user.setLastUpdateTime(date);
        BeanUtils.copyProperties(request,user);
        User save = userRepository.save(user);
        if (save == null){
            log.error("添加用户请求--失败，错误信息：{}",response.getResultMsg());
            return response.buildFail();
        }
        return response.buildSuccess();
    }


    @Override
    public BaseResponse findUserAll() {
        BaseResponse response = new BaseResponse();
        List<User> userAll = userRepository.findAll();
        if (userAll == null){
            return response.buildFail();
        }
        return response.buildSuccess(userAll);
    }

    @Override
    public BaseResponse findUser(String userId) {
        BaseResponse response = new BaseResponse();
        Optional<User> optionalUser = userRepository.findById(userId);
        if (!optionalUser.isPresent()){
            return response.buildFail();
        }
        return response.buildSuccess(optionalUser.get());
    }

    /**
     * 登录
     * @return
     */
    @Override
    public BaseResponse<Object> logon() {

        return null;
    }
}
