package com.learnning.design_patterns.builder_pattern;

/**
 * 类 名 称：TomatoAndEggSoup.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class TomatoAndEggSoup extends AbstractFood {
    protected void addTomatoes() {
        System.out.println("放入西红柿，烧一会");
    }

    protected void addEggs() {
        System.out.println("放入打好的鸡蛋，凝固了再搅拌");
    }

    protected void addWater() {
        System.out.println("加很多水，我们是烧汤的");
    }

    protected void addOil() {
        System.out.println("加油");
    }
}
