package com.learnning.design_patterns.interpreter_pattern;

import java.util.Map;

/**
 * 类 名 称：TerminalExpression.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月24日
 */
public class TerminalExpression extends Expression {
    private String var;

    public TerminalExpression(String var) {
        this.var = var;
    }

    public int interpreter(Map<String, Integer> context) {
        System.out.println("这里计算：" + var + "=" + context.get(var));
        return context.get(var);
    }

    @Override
    public String toString() {
        return var;
    }
}
