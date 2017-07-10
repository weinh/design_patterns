package com.learnning.design_patterns.proxy_pattern.dynamic;

/**
 * 类 名 称：BeforeAdvice.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class BeforeAdvice implements IAdvice {
    public void before() {
        System.out.println("音乐。。。");
    }
}
