package com.yuanqi.service.practice.factory.abstractF;

import com.yuanqi.service.practice.factory.abstractF.impl.CatSpeed;
import com.yuanqi.service.practice.factory.abstractF.impl.DogSpeed;
import com.yuanqi.service.practice.factory.abstractF.intefer.ColorInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.EatInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.SpeedInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 16:19
 * @Describe:
 */
public class SpeedFactory extends AbstraFactory{

    @Override
    public ColorInterface getColor(String name) {
        return null;
    }

    @Override
    public EatInterface getEat(String name) {
        return null;
    }

    @Override
    public SpeedInterface getSpeed(String name) {
        switch (name){
            case "cat":
                return new CatSpeed();
            case "dog":
                return new DogSpeed();
            default:
                return null;
        }
    }
}
