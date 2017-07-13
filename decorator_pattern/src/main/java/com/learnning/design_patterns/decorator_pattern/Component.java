package com.learnning.design_patterns.decorator_pattern;

/**
 * 类 名 称：Component.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月13日
 */
public class Component implements AbstractComponent {
    public void operation() {
        System.out.println("我是一只老虎");
    }
}
