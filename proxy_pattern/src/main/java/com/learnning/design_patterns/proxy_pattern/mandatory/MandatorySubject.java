package com.learnning.design_patterns.proxy_pattern.mandatory;

/**
 * 类 名 称：Subject.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public interface MandatorySubject {
    void exec();
    MandatorySubject getProxy();
}
