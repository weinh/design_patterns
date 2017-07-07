package com.learnning.design_patterns.template_method_pattern;

/**
 * 类 名 称：AbstractTemplate.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public abstract class AbstractTemplate {
    /**
     * 定义基础方法为protected类型，符合迪米特法则
     */
    protected abstract void baseMethod1();

    protected abstract void baseMethod2();

    protected abstract void baseMethod3();

    /**
     * 为了防止搞破坏，将模板方法定义为final类型
     */
    public final void templateMethod() {
        baseMethod1();
        baseMethod2();
        baseMethod3();
    }
}
