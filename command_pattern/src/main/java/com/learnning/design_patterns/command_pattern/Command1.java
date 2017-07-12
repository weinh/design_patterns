package com.learnning.design_patterns.command_pattern;

/**
 * 类 名 称：Command1.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月12日
 */
public class Command1 extends AbstractCommand {
    protected void execute() {
        super.receive1.doSomething();
        super.receive2.doSomething();
    }
}
