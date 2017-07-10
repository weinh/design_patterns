package com.learnning.design_patterns.proxy_pattern.definition;

import com.learnning.design_patterns.proxy_pattern.Subject;

/**
 * 类 名 称：ProxySubject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
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
