package com.learnning.design_patterns.adapter_pattern.ObjectAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：AdapteeHomeInfo.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月25日
 */
public class AdapteeHomeInfo {
    public Map<String, String> getHomeInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("homeTel", "0000");
        map.put("userName", "老三");
        map.put("addr", "杭州");
        return map;
    }
}
