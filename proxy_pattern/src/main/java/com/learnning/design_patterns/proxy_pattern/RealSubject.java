package com.learnning.design_patterns.proxy_pattern;

import com.learnning.design_patterns.proxy_pattern.Subject;

/**
 * 类 名 称：RealSubject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class RealSubject implements Subject {
    public void exec() {
        System.out.println("真实对象表演ing");
    }
}
