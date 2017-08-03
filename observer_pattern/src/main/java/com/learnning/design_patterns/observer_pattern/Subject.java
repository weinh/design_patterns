package com.learnning.design_patterns.observer_pattern;

import java.util.Vector;

/**
 * 类 名 称：Subject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月03日
 */
public abstract class Subject {
    private Vector<Observer> obsVertor = new Vector<Observer>();

    public void addObserver(Observer observer) {
        obsVertor.add(observer);
    }

    public void removeObserver(Observer observer) {
        obsVertor.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : obsVertor) {
            observer.update();
        }
    }
}
