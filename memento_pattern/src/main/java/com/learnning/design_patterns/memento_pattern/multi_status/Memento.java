package com.learnning.design_patterns.memento_pattern.multi_status;

import java.util.Map;

/**
 * 类 名 称：Memento.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年08月17日
 */
public class Memento {
    private Map<String, Object> statusMap;

    public Memento(Map<String, Object> stringStringMap) {
        statusMap = stringStringMap;
    }

    public Map<String, Object> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, Object> statusMap) {
        this.statusMap = statusMap;
    }
}
