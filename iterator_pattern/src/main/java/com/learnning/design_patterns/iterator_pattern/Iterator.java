package com.learnning.design_patterns.iterator_pattern;

/**
 * 类 名 称：Iterator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月27日
 */
public interface Iterator {
    Object next();

    boolean hasNext();

    boolean remove();
}
