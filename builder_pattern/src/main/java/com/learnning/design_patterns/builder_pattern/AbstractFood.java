package com.learnning.design_patterns.builder_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 类 名 称：AbstractFood.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public abstract class AbstractFood {
    private List<String> steps = new ArrayList<String>();

    protected abstract void addTomatoes();

    protected abstract void addEggs();

    protected abstract void addWater();

    protected abstract void addOil();

    private void addSalt() {
        System.out.println("放入适量的盐");
    }

    private void outPot() {
        System.out.println("出锅");
    }

    public final void show() {
        for (String step : steps) {
            if ("Tomatoes".equals(step)) {
                this.addTomatoes();
            } else if ("Eggs".equals(step)) {
                this.addEggs();
            } else if ("Water".equals(step)) {
                this.addWater();
            } else if ("Oil".equals(step)) {
                this.addOil();
            }
        }
        this.addSalt();
        this.outPot();
    }

    protected final void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
