package com.yuanqi.service.practice.factory.abstractF.impl;

import com.yuanqi.service.practice.factory.abstractF.intefer.ColorInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:41
 * @Describe:
 */
public class CatColor implements ColorInterface {
    @Override
    public void color() {
        System.out.println("花色猫");
    }
}
