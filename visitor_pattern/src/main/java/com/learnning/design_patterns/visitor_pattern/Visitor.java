package com.learnning.design_patterns.visitor_pattern;

/**
 * 类 名 称：Visitor.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月23日
 */
public class Visitor implements IVisitor {

    public void visitor(Element element) {
        System.out.println("我是Element：" + element.doSomething() + "的访问者");
    }

    public void visitor(Element1 element) {
        System.out.println("我是Element1：" + element.doSomething() + "的访问者");
    }

}
