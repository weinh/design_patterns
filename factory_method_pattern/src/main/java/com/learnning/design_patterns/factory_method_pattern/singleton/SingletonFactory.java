package com.learnning.design_patterns.factory_method_pattern.singleton;

import java.lang.reflect.Constructor;

/**
 * 类 名 称：SingletonFactory.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public class SingletonFactory {
    private static Singleton singleton;

    static {
        try {
            Class clazz = Class.forName(Singleton.class.getName());
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);//设定构造方法是可以访问的
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("使用工厂方法创建单例出错");
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
