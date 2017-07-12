package com.learnning.design_patterns.command_pattern;

/**
 * 类 名 称：Invoker.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月12日
 */
public class Invoker {
    private AbstractCommand command;

    public void setCommand(AbstractCommand command) {
        this.command = command;
    }

    public void action() {
        this.command.execute();
    }
}
