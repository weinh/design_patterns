package com.learnning.design_patterns.interpreter_pattern;

import java.util.Map;
import java.util.Stack;

/**
 * 类 名 称：Calc.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月24日
 */
public class Calc {
    private String expression;

    public Calc(String expression) {
        this.expression = expression;
    }

    public int calc(Map<String, Integer> vars) {
        Stack<Expression> expressionStack = new Stack<Expression>();
        char charArray[] = expression.toCharArray();
        Expression left;
        Expression right;
        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case '+':
                    left = expressionStack.pop();
                    right = new TerminalExpression(String.valueOf(charArray[++i]));
                    expressionStack.push(new AddExpression(left, right));
                    break;
                case '-':
                    left = expressionStack.pop();
                    right = new TerminalExpression(String.valueOf(charArray[++i]));
                    expressionStack.push(new SubExpression(left, right));
                    break;
                default:
                    expressionStack.push(new TerminalExpression(String.valueOf(charArray[i])));
                    break;
            }
        }
        return expressionStack.pop().interpreter(vars);
    }
}
