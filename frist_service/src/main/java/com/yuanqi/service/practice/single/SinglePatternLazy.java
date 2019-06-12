package com.yuanqi.service.practice.single;

/**
 * @Author: yq
 * @Date：2019/6/6 14:59
 * @Describe:
 */
public class SinglePatternLazy {

    private static SinglePatternLazy instance;

    private SinglePatternLazy (){}

    public static SinglePatternLazy getInstance(){
        if (instance == null){
            instance = new SinglePatternLazy();
        }
        return instance;
    }
}
