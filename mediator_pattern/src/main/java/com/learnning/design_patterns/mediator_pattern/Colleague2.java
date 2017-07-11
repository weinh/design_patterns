package com.learnning.design_patterns.mediator_pattern;

/**
 * 类 名 称：Colleague2.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月11日
 */
public class Colleague2 extends AbstractColleague {
    public Colleague2(AbstractMediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        super.mediator.send(message, this);
    }

    void notify(String message) {
        System.out.println("同事2收到消息：" + message);
    }
}
