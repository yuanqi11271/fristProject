package com.yuanqi.service.user.controller;

import com.yuanqi.common.request.user.UserCreateRequest;
import com.yuanqi.common.response.BaseResponse;
import com.yuanqi.service.user.service.LogonService;
import com.yuanqi.service.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: yq
 * @Date：2019/4/18 14:49
 * 用户
 */
@RestController
@Slf4j
@RequestMapping("/user")
@Api("用户信息接口")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LogonService logonService;

    /**
     * 登录
     * @return
     */
    @GetMapping("/logon")
    public BaseResponse logon(){
        BaseResponse<Object> response = new BaseResponse<>();
        response.buildSuccess();
        return response;
    }

    @PostMapping("/insertUser")
    @ApiOperation(value = "新增用户",notes = "用户注册")
    public BaseResponse insertUser(@RequestBody UserCreateRequest request){
        BaseResponse<Object> res = new BaseResponse<>();
        return userService.insertUser(request);
    }

    @GetMapping("/findUser/{userId}")
    @ApiOperation(value = "查询用户",notes = "用户查询")
    public BaseResponse findUser(@PathVariable("userId") String userId){
        return userService.findUser(userId);
    }

    @GetMapping("/findUserAll")
    @ApiOperation(value = "查询用户",notes = "用户查询")
    public BaseResponse findUserAll() {
        return userService.findUserAll();
    }

}
