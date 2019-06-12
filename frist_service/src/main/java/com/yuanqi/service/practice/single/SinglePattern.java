package com.yuanqi.service.practice.single;

/**
 * @Author: yq
 * @Date：2019/6/6 10:12
 * @Describe: 单例模式
 */
public class SinglePattern {

    private static final SinglePattern instance = new SinglePattern();

    private SinglePattern (){}

    public static SinglePattern getInstance (){
        return instance;
    }

}
