package com.learnning.design_patterns.flyweight_pattern;

/**
 * 类 名 称：Flyweight.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月25日
 */
public abstract class Flyweight {
    private String intrinsic;
    protected final String extrinsic;

    protected Flyweight(String extrinsic) {
        this.extrinsic = extrinsic;
    }

    public abstract void operate();

    public String getIntrinsic() {
        return intrinsic;
    }

    public void setIntrinsic(String intrinsic) {
        this.intrinsic = intrinsic;
    }
}
