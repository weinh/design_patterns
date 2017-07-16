package com.learnning.design_patterns.strategy_pattern;

/**
 * 类 名 称：Context.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月16日
 */
public class Context {
    private AbstractStrategy strategy;

    public Context(AbstractStrategy strategy) {
        this.strategy = strategy;
    }

    public void operation() {
        this.strategy.operation();
    }
}
