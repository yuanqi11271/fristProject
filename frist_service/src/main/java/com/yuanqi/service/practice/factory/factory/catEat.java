package com.yuanqi.service.practice.factory.factory;

import com.yuanqi.service.practice.factory.factory.interfac.EatInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:18
 * @Describe:
 */
public class catEat implements EatInterface {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
