package com.learnning.design_patterns.singleton_pattern;

/**
 * 类 名 称：HungrySingleton.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public class HungrySingleton {

    /**
     * 自行实例化
     */
    private final static HungrySingleton hungrySingletion = new HungrySingleton();

    /**
     * 只有一个实例
     */
    private HungrySingleton() {
    }

    /**
     * 向系统提供实例对象
     *
     * @return
     */
    public static HungrySingleton getInstance() {
        return hungrySingletion;
    }
}
