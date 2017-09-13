package com.learnning.design_patterns.status_pattern;

/**
 * 类 名 称：Context.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月13日
 */
public class Context {
    public static Status STATUS1 = new ConcreteStatus1();
    public static Status STATUS2 = new ConCreteStatus2();

    private Status currentStatus;

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
        this.currentStatus.setContext(this);
    }

    public void handleStatus1() {
        currentStatus.handleStatus1();
    }

    public void handleStatus2() {
        currentStatus.handleStatus2();
    }
}
