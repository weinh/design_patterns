package com.learnning.design_patterns.iterator_pattern;

import java.util.Vector;

/**
 * 类 名 称：ConCreteAggregate.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月27日
 */
public class ConCreteAggregate implements Aggregate {
    private Vector vector = new Vector();

    public void add(Object object) {
        vector.add(object);
    }

    public void remove(Object object) {
        vector.remove(object);
    }

    public Iterator iterator() {
        return new ConcreteIterator(vector);
    }
}
