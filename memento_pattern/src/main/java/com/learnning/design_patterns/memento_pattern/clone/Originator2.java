package com.learnning.design_patterns.memento_pattern.clone;

/**
 * 类 名 称：Originator2.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Originator2 implements Cloneable {
    private String status;

    private Originator2 backup;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void createMemento() {
        backup = this.clone();
    }

    public void restoreMemento() {
        setStatus(backup.getStatus());
    }

    @Override
    protected Originator2 clone() {
        try {
            return (Originator2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
