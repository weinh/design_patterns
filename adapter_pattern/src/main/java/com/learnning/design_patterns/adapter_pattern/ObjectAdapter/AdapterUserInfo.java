package com.learnning.design_patterns.adapter_pattern.ObjectAdapter;

/**
 * 类 名 称：AdapterUserInfo.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月25日
 */
public class AdapterUserInfo implements IUserInfo {

    private AdapteeHomeInfo homeInfo;
    private AdapteeOfficeInfo officeInfo;

    public AdapterUserInfo(AdapteeHomeInfo homeInfo, AdapteeOfficeInfo officeInfo) {
        this.homeInfo = homeInfo;
        this.officeInfo = officeInfo;
    }

    public String getUserName() {
        return homeInfo.getHomeInfo().get("userName");
    }

    public String getAddr() {
        return homeInfo.getHomeInfo().get("addr");
    }

    public String getOfficeTel() {
        return officeInfo.getOfficeInfo().get("officeTel");
    }

    public String getHomeTel() {
        return homeInfo.getHomeInfo().get("homeTel");
    }
}
