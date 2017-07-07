package com.learnning.design_patterns.template_method_pattern;

/**
 * 类 名 称：Template2.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class Template2 extends AbstractTemplate {
    protected void baseMethod1() {
        System.out.println("模板2——步骤1");
    }

    protected void baseMethod2() {
        System.out.println("模板2——步骤2");
    }

    protected void baseMethod3() {
        System.out.println("模板2——步骤3");
    }
}
