package com.learnning.design_patterns.facade_pattern;

/**
 * 类 名 称：Facade.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月09日
 */
public class Facade {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();
    private ClassC c = new ClassC();

    public void doSomethingA() {
        a.doSomething();
    }

    public void doSomethingB() {
        b.doSomething();
    }

    public void doSomethingC() {
        c.doSomething();
    }
}
