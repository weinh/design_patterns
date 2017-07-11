package com.learnning.design_patterns.mediator_pattern;

/**
 * 类 名 称：AbstractColleague.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月11日
 */
public abstract class AbstractColleague {
    protected AbstractMediator mediator;

    public AbstractColleague(AbstractMediator mediator) {
        this.mediator = mediator;
    }
}
