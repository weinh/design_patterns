package com.learnning.design_patterns.builder_pattern;

import java.util.List;

/**
 * 类 名 称：AbstractChef.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public abstract class AbstractChef {
    public abstract void setSteps(List<String> steps);

    public abstract AbstractFood cooking();
}
