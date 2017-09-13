package com.learnning.design_patterns.status_pattern;

/**
 * 类 名 称：Status.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月13日
 */
public abstract class Status {
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public abstract void handleStatus1();

    public abstract void handleStatus2();
}
