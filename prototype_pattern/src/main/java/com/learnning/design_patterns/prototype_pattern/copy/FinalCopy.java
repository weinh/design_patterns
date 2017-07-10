package com.learnning.design_patterns.prototype_pattern.copy;

import java.util.ArrayList;

/**
 * 类 名 称：FinalCopy.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class FinalCopy implements Cloneable {
    private final ArrayList<String> list = new ArrayList<String>();

    @Override
    public FinalCopy clone() throws CloneNotSupportedException {
        FinalCopy finalCopy = (FinalCopy) super.clone();
//        finalCopy.list = (ArrayList<String>) this.list.clone();
        return finalCopy;
    }

    public void setList(String name) {
        list.add(name);
    }

    public void show() {
        System.out.println(list);
    }
}
