package com.learnning.design_patterns.command_pattern;

/**
 * 类 名 称：AbstractCommand.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月12日
 */
public abstract class AbstractCommand {
    protected AbstractReceive receive1 = new Receive1();
    protected AbstractReceive receive2 = new Receive2();

    protected abstract void execute();
}
