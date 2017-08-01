package com.learnning.design_patterns.composite_pattern.transparent;

import java.util.List;

/**
 * 类 名 称：Component.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月01日
 */
public abstract class Component {
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("我是" + name);
    }

    public abstract void add(Component component);

    public abstract List<Component> getChild();
}
