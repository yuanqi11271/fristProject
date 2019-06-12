package com.yuanqi.service.practice.factory.abstractF;

import com.yuanqi.service.practice.factory.abstractF.impl.CatColor;
import com.yuanqi.service.practice.factory.abstractF.impl.GodColor;
import com.yuanqi.service.practice.factory.abstractF.intefer.ColorInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.EatInterface;
import com.yuanqi.service.practice.factory.abstractF.intefer.SpeedInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:50
 * @Describe:
 */
public class ColorFactory extends AbstraFactory{

    @Override
    public ColorInterface getColor(String name) {
        switch (name){
            case "cat":
                return new CatColor();
            case "dog":
                return new GodColor();
            default:
                return null;
        }
    }

    @Override
    public EatInterface getEat(String name) {
        return null;
    }

    @Override
    public SpeedInterface getSpeed(String name) {
        return null;
    }
}
