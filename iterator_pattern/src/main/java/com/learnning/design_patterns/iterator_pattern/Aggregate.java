package com.learnning.design_patterns.iterator_pattern;

/**
 * 类 名 称：Aggregate.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月27日
 */
public interface Aggregate {
    void add(Object object);

    void remove(Object object);

    Iterator iterator();
}
