package com.yuanqi.service.practice.factory.factory;

import com.yuanqi.service.practice.factory.factory.interfac.EatInterface;

/**
 * @Author: yq
 * @Date：2019/6/6 15:21
 * @Describe:
 */
public class EatFactory {

    public static EatInterface getEat(String name){
        switch (name){
            case "cat":
                return new catEat();
            case "god":
                return new godEat();
            default:
                return null;
        }
    }
}
