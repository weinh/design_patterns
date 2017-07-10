package com.learnning.design_patterns.proxy_pattern.mandatory;

/**
 * 类 名 称：MandatoryRealSubject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class MandatoryRealSubject implements MandatorySubject {

    private MandatorySubject proxy = null;

    public MandatoryRealSubject() {

    }

    public MandatorySubject getProxy() {
        proxy = new MandatoryProxySubject(this);
        return proxy;
    }

    public void exec() {
        if (isProxy()) {
            System.out.println("强制代理的表演ing");
        } else {
            System.out.println("要看表演，先联系我的经纪人");
        }
    }

    private boolean isProxy() {
        return proxy != null;
    }
}
