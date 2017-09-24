package com.learnning.design_patterns.interpreter_pattern;

import java.util.Map;

/**
 * 类 名 称：AddExpression.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月24日
 */
public class AddExpression extends NonTerminalExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(Map<String, Integer> context) {
        System.out.println("这里计算：" + left + "+" + right);
        return super.left.interpreter(context) + super.right.interpreter(context);
    }

    @Override
    public String toString() {
        return left + "+" + right;
    }
}
