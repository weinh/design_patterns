package com.learnning.design_patterns.mediator_pattern;

/**
 * 类 名 称：Mediator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月11日
 */
public class Mediator extends AbstractMediator {
    @Override
    protected void send(String message, AbstractColleague colleague) {
        if (c1.equals(colleague)) {
            c2.notify(message);
        } else if (c2.equals(colleague)) {
            c1.notify(message);
        }
    }
}
