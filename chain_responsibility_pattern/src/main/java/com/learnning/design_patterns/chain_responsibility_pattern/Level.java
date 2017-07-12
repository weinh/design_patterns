package com.learnning.design_patterns.chain_responsibility_pattern;

/**
 * 类 名 称：Level.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月12日
 */
public class Level {
    private int level;

    public Level(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Level) {
            return this.level == ((Level) obj).level;
        } else {
            return false;
        }
    }
}
