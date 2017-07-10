package com.learnning.design_patterns.prototype_pattern;

/**
 * 类 名 称：PrototypeClass.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class PrototypeClass implements Cloneable {
    private String name;

    public PrototypeClass(String name) {
        System.out.println("构造方法执行");
        this.name = name;
    }

    @Override
    public PrototypeClass clone() throws CloneNotSupportedException {
        return (PrototypeClass) super.clone();
    }

    public void show() {
        System.out.println("我是" + name);
    }
}
