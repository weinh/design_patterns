package com.learnning.design_patterns.adapter_pattern;

/**
 * 类 名 称：ConcreateTarget.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月25日
 */
public class ConcreateTarget implements Target {
    public void request() {
        System.out.println("目标对象实现");
    }
}
