package com.yuanqi.service.practice.factory.abstractF;

import com.yuanqi.service.practice.factory.abstractF.intefer.ColorInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.EatInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.SpeedInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:46
 * @Describe:
 */
public abstract class AbstraFactory {
    public abstract ColorInterface getColor(String name);
    public abstract EatInterface getEat(String name);
    public abstract SpeedInterface getSpeed(String name);
}
