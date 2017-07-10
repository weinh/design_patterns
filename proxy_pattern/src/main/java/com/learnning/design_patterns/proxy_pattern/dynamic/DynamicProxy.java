package com.learnning.design_patterns.proxy_pattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 类 名 称：DynamicProxy.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader cl, Class<?>[] interfaces, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(cl, interfaces, handler);
    }
}
