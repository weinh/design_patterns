package com.learnning.design_patterns.proxy_pattern.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 类 名 称：Handler.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class Handler implements InvocationHandler {

    private Object object;

    public Handler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        new BeforeAdvice().before();
        return method.invoke(object, args);
    }
}
