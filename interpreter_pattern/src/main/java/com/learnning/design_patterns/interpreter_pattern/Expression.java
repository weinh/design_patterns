package com.learnning.design_patterns.interpreter_pattern;

import java.util.Map;

/**
 * 类 名 称：Expression.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月24日
 */
public abstract class Expression {
    public abstract int interpreter(Map<String, Integer> context);
}
