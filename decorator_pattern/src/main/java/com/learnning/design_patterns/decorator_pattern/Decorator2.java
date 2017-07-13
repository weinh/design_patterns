package com.learnning.design_patterns.decorator_pattern;

/**
 * 类 名 称：Decorator2.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月13日
 */
public class Decorator2 extends Decorator {
    public Decorator2(AbstractComponent component) {
        super(component);
    }

    private void decoratorMethod(){
        System.out.println("我是个玩具");
    }

    @Override
    public void operation() {
        super.operation();
        decoratorMethod();
    }
}
