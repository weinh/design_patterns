package com.learnning.design_patterns.decorator_pattern;

/**
 * 类 名 称：Decorator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月13日
 */
public abstract class Decorator implements AbstractComponent {
    private AbstractComponent component;

    public Decorator(AbstractComponent component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}
