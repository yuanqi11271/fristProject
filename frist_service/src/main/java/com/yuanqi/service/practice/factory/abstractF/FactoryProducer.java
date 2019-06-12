package com.yuanqi.service.practice.factory.abstractF;

/**
 * @Author: yq
 * @Date：2019/6/6 16:02
 * @Describe:
 */
public class FactoryProducer {

    public static AbstraFactory getFactory(String name) {
        switch (name) {
            case "color":
                return new ColorFactory();
            case "eat":
                return new EatFactory();
            case "speed":
                return new SpeedFactory();
            default:
                return null;
        }
    }

}
