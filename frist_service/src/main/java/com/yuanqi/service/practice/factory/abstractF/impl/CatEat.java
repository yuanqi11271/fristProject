package com.yuanqi.service.practice.factory.abstractF.impl;

import com.yuanqi.service.practice.factory.abstractF.intefer.EatInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:18
 * @Describe:
 */
public class CatEat implements EatInterface {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
