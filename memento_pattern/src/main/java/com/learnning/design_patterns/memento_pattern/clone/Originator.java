package com.learnning.design_patterns.memento_pattern.clone;

/**
 * 类 名 称：Originator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Originator implements Cloneable {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Originator createMemento() {
        return this.clone();
    }

    public void restoreMemento(Originator originator) {
        setStatus(originator.getStatus());
    }

    @Override
    protected Originator clone() {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
