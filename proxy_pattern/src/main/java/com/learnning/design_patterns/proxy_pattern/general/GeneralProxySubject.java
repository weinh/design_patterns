package com.learnning.design_patterns.proxy_pattern.general;

import com.learnning.design_patterns.proxy_pattern.Subject;

/**
 * 类 名 称：GeneralProxySubject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class GeneralProxySubject implements Subject {
    private Subject subject;

    public GeneralProxySubject() {
        subject = new GeneralRealSubject(this);
    }

    public void exec() {
        before();
        subject.exec();
        after();
    }

    private void before() {
        System.out.println("节目开始");
    }

    private void after() {
        System.out.println("节目结束");
    }
}
