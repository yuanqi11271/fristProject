package com.yuanqi.service.practice.factory.abstractF.impl;

import com.yuanqi.service.practice.factory.abstractF.intefer.SpeedInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 16:15
 * @Describe:
 */
public class CatSpeed implements SpeedInterface {
    @Override
    public void speed() {
        System.out.println("速度慢");
    }
}
