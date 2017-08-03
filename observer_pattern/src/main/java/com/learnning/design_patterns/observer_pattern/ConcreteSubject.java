package com.learnning.design_patterns.observer_pattern;

/**
 * 类 名 称：ConcreteSubject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月03日
 */
public class ConcreteSubject extends Subject {
    public void doSomething() {
        System.out.println("被观察者有动作了");
        super.notifyObservers();
    }
}
