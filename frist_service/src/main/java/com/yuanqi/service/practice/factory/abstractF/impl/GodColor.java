package com.yuanqi.service.practice.factory.abstractF.impl;

import com.yuanqi.service.practice.factory.abstractF.intefer.ColorInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:42
 * @Describe:
 */
public class GodColor implements ColorInterface {
    @Override
    public void color() {
        System.out.println("黑狗");
    }
}
