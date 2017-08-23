package com.learnning.design_patterns.visitor_pattern;

/**
 * 类 名 称：Element.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月23日
 */
public class Element implements IElement {
    private String name;

    public Element(String name) {
        this.name = name;
    }

    public void accept(IVisitor visitor) {
        visitor.visitor(this);
    }

    public String doSomething() {
        return name;
    }
}
