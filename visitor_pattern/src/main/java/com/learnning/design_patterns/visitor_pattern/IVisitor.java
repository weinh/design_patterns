package com.learnning.design_patterns.visitor_pattern;

/**
 * 类 名 称：IVisitor.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月23日
 */
public interface IVisitor {
    void visitor(Element element);

    void visitor(Element1 element);
}
