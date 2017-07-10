package com.learnning.design_patterns.prototype_pattern.copy;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：CopyAny.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class CopyAny implements Cloneable {
    private List<String> list = new ArrayList<String>();

    @Override
    public CopyAny clone() throws CloneNotSupportedException {
        return (CopyAny) super.clone();
    }

    public void setList(String name) {
        list.add(name);
    }

    public void show() {
        System.out.println(list);
    }
}
