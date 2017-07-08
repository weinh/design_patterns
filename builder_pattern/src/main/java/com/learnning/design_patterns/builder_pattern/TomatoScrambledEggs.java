package com.learnning.design_patterns.builder_pattern;

/**
 * 类 名 称：TomatoScrambledEggs.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class TomatoScrambledEggs extends AbstractFood {
    protected void addTomatoes() {
        System.out.println("加入番茄翻炒一会，炒出汤汁，加入鸡蛋翻炒");
    }

    protected void addEggs() {
        System.out.println("炒个鸡蛋，弄小块，装盘");
    }

    protected void addWater() {
        System.out.println("加水");
    }

    protected void addOil() {
        System.out.println("加入油，加热");
    }
}
