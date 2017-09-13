package com.learnning.design_patterns.status_pattern;

/**
 * 类 名 称：ConCreteStatus2.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月13日
 */
public class ConCreteStatus2 extends Status {
    public void handleStatus1() {
        System.out.println("即将切换到状态1");
        super.context.setCurrentStatus(Context.STATUS1);
        super.context.handleStatus1();
    }

    public void handleStatus2() {
        System.out.println("我是状态2");
    }
}
