package com.learnning.design_patterns.strategy_pattern;

/**
 * 类 名 称：StrategyEnum.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月16日
 */
public enum StrategyEnum {
    ADD("+") {
        public int exec(int a, int b) {
            return a + b;
        }
    },

    SUB("-") {
        public int exec(int a, int b) {
            return a - b;
        }
    };

    private String operation;

    StrategyEnum(String operation) {
        this.operation = operation;
    }

    public abstract int exec(int a, int b);
}
