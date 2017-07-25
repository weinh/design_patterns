package com.learnning.design_patterns.adapter_pattern;

/**
 * 类 名 称：Adapter.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月25日
 */
public class Adapter extends Adaptee implements Target {
    public void request() {
        super.dosomething();
    }
}
