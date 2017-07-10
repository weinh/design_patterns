package com.learnning.design_patterns.proxy_pattern.dynamic;

import com.learnning.design_patterns.proxy_pattern.Subject;

import java.lang.reflect.InvocationHandler;

/**
 * 类 名 称：SubjectDynamicProxy.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class SubjectDynamicProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader cl = subject.getClass().getClassLoader();
        Class<?> interfaces[] = subject.getClass().getInterfaces();
        InvocationHandler handler = new Handler(subject);
        return newProxyInstance(cl, interfaces, handler);
    }
}
