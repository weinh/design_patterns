package com.learnning.design_patterns.facade_pattern;

/**
 * 类 名 称：ComplexClass.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月09日
 */
public class ComplexClass {
    private ClassA a = new ClassA();
    private ClassB b = new ClassB();

    public void doSomething() {
        a.doSomething();
        b.doSomething();
    }
}
