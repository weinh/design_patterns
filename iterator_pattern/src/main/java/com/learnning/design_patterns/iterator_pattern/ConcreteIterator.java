package com.learnning.design_patterns.iterator_pattern;

import java.util.Vector;

/**
 * 类 名 称：ConcreteIterator.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月27日
 */
public class ConcreteIterator implements Iterator {
    private Vector vector = new Vector();
    private int cursor = 0;

    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    public Object next() {
        if (hasNext()) {
            return vector.get(cursor++);
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return cursor != vector.size();
    }

    public boolean remove() {
        vector.remove(cursor);
        return true;
    }
}
