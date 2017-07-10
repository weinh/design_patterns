package com.learnning.design_patterns.proxy_pattern.general;

import com.learnning.design_patterns.proxy_pattern.Subject;

/**
 * 类 名 称：GeneralRealSubject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class GeneralRealSubject implements Subject {

    public GeneralRealSubject(Subject proxy) {
        if (proxy == null) {
            new RuntimeException("不能创建对象");
        }
    }

    public void exec() {
        System.out.println("普通代理的表演ing");
    }
}
