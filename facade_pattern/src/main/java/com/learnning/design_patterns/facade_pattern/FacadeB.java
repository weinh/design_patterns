package com.learnning.design_patterns.facade_pattern;

/**
 * 类 名 称：FacadeB.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月09日
 */
public class FacadeB {
    private ClassA a = new ClassA();
    private ComplexClass complexClass = new ComplexClass();
    private ClassC c = new ClassC();

    public void doSomethingA() {
        a.doSomething();
    }

    public void doSomethingB() {
        complexClass.doSomething();
    }

    public void doSomethingC() {
        c.doSomething();
    }
}
