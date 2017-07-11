package com.learnning.design_patterns.mediator_pattern;

/**
 * 类 名 称：AbstractMediator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月11日
 */
public abstract class AbstractMediator {
    protected Colleague1 c1;
    protected Colleague2 c2;

    public Colleague1 getC1() {
        return c1;
    }

    public void setC1(Colleague1 c1) {
        this.c1 = c1;
    }

    public Colleague2 getC2() {
        return c2;
    }

    public void setC2(Colleague2 c2) {
        this.c2 = c2;
    }

    protected abstract void send(String message, AbstractColleague colleague);
}
