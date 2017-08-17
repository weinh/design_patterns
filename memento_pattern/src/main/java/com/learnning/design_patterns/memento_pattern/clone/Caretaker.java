package com.learnning.design_patterns.memento_pattern.clone;

/**
 * 类 名 称：Caretaker.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Caretaker {
    private Originator originator;

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
