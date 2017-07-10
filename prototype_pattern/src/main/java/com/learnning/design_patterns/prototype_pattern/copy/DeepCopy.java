package com.learnning.design_patterns.prototype_pattern.copy;

import java.util.ArrayList;

/**
 * 类 名 称：DeepCopy.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class DeepCopy implements Cloneable {
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    public DeepCopy clone() throws CloneNotSupportedException {
        DeepCopy deepCopy = (DeepCopy) super.clone();
        deepCopy.list = (ArrayList<String>) this.list.clone();
        return deepCopy;
    }

    public void setList(String name) {
        list.add(name);
    }

    public void show() {
        System.out.println(list);
    }
}
