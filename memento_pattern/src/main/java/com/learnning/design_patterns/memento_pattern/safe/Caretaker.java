package com.learnning.design_patterns.memento_pattern.safe;

/**
 * 类 名 称：Caretaker.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Caretaker {
    private IMemento memento;

    public IMemento getMemento() {
        return memento;
    }

    public void setMemento(IMemento memento) {
        this.memento = memento;
    }
}
