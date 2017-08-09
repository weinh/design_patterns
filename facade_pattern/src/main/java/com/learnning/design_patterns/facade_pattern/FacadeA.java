package com.learnning.design_patterns.facade_pattern;

/**
 * 类 名 称：FacadeA.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月09日
 */
public class FacadeA {
    private Facade facade = new Facade();

    public void doSomethingB() {
        facade.doSomethingB();
    }
}
