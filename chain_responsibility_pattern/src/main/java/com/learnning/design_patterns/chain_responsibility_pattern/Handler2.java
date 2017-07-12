package com.learnning.design_patterns.chain_responsibility_pattern;

/**
 * 类 名 称：Handler2.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月13日
 */
public class Handler2 extends AbstractHandler {
    protected Response echo(Request request) {
        System.out.println("handler2处理请求");
        return null;
    }

    protected Level getHandlerLevel() {
        return new Level(2);
    }
}
