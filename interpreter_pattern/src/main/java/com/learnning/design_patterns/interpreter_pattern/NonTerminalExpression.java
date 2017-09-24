package com.learnning.design_patterns.interpreter_pattern;

/**
 * 类 名 称：NonTerminalExpression.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月24日
 */
public abstract class NonTerminalExpression extends Expression {
    Expression left;
    Expression right;

    public NonTerminalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
