package com.learnning.design_patterns.observer_pattern;

/**
 * 类 名 称：ConcreteObserver.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月03日
 */
public class ConcreteObserver implements Observer {
    public void update() {
        System.out.println("观察到被观察者有动作，");
    }
}
