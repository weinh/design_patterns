package com.learnning.design_patterns.adapter_pattern.ObjectAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：AdapteeOfficeInfo.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月25日
 */
public class AdapteeOfficeInfo {
    public Map<String, String> getOfficeInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("officeTel", "1111");
        return map;
    }
}
