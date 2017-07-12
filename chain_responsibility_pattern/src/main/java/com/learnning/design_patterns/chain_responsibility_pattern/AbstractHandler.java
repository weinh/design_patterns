package com.learnning.design_patterns.chain_responsibility_pattern;

/**
 * 类 名 称：AbstractHandler.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月12日
 */
public abstract class AbstractHandler {
    private AbstractHandler nextHandler;

    public final Response handlerMessage(Request request) {
        Response response = null;
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            if (this.nextHandler != null) {
                response = this.nextHandler.handlerMessage(request);
            } else {
                System.out.println("请求非法");
            }
        }
        return response;

    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract Response echo(Request request);

    protected abstract Level getHandlerLevel();
}
