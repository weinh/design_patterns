package com.learnning.design_patterns.memento_pattern;

/**
 * 类 名 称：Originator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Originator {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Memento createMemento() {
        return new Memento(status);
    }

    public void setMemento(Memento memento) {
        setStatus(memento.getStatus());
    }
}
