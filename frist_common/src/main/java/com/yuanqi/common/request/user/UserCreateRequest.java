package com.yuanqi.common.request.user;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @Author: yq
 * @Date：2019/4/18 16:41
 */
@Data
public class UserCreateRequest {

    /**
     * id添加时可以为空，修改时需要
     */
    @ApiParam(name = "用户id",required = false)
    String customerId;

    @ApiParam("用户名称")
    @NotNull
    String customerName;

    @ApiParam("用户手机号")
    String customerPhone;

    @ApiParam("用户身份证号")
    @NotNull
    String IdCard;

    @ApiParam("性别")
    String sex;

    @ApiParam("年龄")
    Integer age;
}
