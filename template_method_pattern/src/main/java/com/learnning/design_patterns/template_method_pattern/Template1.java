package com.learnning.design_patterns.template_method_pattern;

/**
 * 类 名 称：Template1.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class Template1 extends AbstractTemplate {
    /**
     * 没有特殊情况，子类覆盖的方法不会扩大访问范围
     */
    protected void baseMethod1() {
        System.out.println("模板1——步骤1");
    }

    protected void baseMethod2() {
        System.out.println("模板1——步骤2");
    }

    protected void baseMethod3() {
        System.out.println("模板1——步骤3");
    }
}
