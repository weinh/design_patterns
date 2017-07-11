package com.learnning.design_patterns.mediator_pattern;

/**
 * 类 名 称：Colleague1.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月11日
 */
public class Colleague1 extends AbstractColleague {
    public Colleague1(AbstractMediator mediator) {
        super(mediator);
    }

    public void send(String message) {
        super.mediator.send(message, this);
    }

    void notify(String message) {
        System.out.println("同事1收到消息：" + message);
    }
}
