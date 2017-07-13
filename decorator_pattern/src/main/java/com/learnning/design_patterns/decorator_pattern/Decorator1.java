package com.learnning.design_patterns.decorator_pattern;

/**
 * 类 名 称：Decorator1.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月13日
 */
public class Decorator1 extends Decorator {
    public Decorator1(AbstractComponent component) {
        super(component);
    }

    private void decoratorMethod(){
        System.out.println("我纸做的");
    }

    @Override
    public void operation() {
        decoratorMethod();
        super.operation();
    }
}
