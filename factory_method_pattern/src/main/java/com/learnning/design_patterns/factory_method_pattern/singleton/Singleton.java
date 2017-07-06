package com.learnning.design_patterns.factory_method_pattern.singleton;

/**
 * 类 名 称：Singleton.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public class Singleton {
    private Singleton() {
    }

    public void introduce() {
        System.out.println("我是单例");
    }
}
