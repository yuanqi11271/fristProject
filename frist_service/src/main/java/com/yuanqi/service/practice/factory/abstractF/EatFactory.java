package com.yuanqi.service.practice.factory.abstractF;

import com.yuanqi.service.practice.factory.abstractF.impl.CatEat;
import com.yuanqi.service.practice.factory.abstractF.impl.GodEat;
import com.yuanqi.service.practice.factory.abstractF.intefer.ColorInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.EatInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.SpeedInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:53
 * @Describe:
 */
public class EatFactory extends AbstraFactory {

    @Override
    public ColorInterface getColor(String name) {
        return null;
    }

    @Override
    public EatInterface getEat(String name) {
        switch (name){
            case "cat":
                return new CatEat();
            case "god":
                return new GodEat();
            default:
                return null;
        }
    }

    @Override
    public SpeedInterface getSpeed(String name) {
        return null;
    }
}
