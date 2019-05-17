package com.yuanqi.service;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @Author: yq
 * @Date：2019/5/17 11:31
 * @Describe:
 */
public class SendSms {

    public static void main(String[] args) {
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI6oBQKAiSJVRa", "yfziVt3WvG1dI8woxfEVJaE95GkG0c");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", "15938102712");
        request.putQueryParameter("SignName", "吃货");
        request.putQueryParameter("TemplateCode", "SMS_165412506");
        request.putQueryParameter("TemplateParam", "{code:3256}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
