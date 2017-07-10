package com.learnning.design_patterns.proxy_pattern.mandatory;

/**
 * 类 名 称：MandatoryProxySubject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class MandatoryProxySubject implements MandatorySubject {

    private MandatorySubject subject;

    public MandatoryProxySubject(MandatorySubject target) {
        this.subject = target;
    }

    public void exec() {
        before();
        subject.exec();
        after();
    }

    public MandatorySubject getProxy() {
        return this;
    }

    private void before() {
        System.out.println("节目开始");
    }

    private void after() {
        System.out.println("节目结束");
    }
}
