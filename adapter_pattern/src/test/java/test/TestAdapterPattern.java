package test;

import com.learnning.design_patterns.adapter_pattern.Adapter;
import com.learnning.design_patterns.adapter_pattern.ConcreateTarget;
import com.learnning.design_patterns.adapter_pattern.ObjectAdapter.AdapteeHomeInfo;
import com.learnning.design_patterns.adapter_pattern.ObjectAdapter.AdapteeOfficeInfo;
import com.learnning.design_patterns.adapter_pattern.ObjectAdapter.AdapterUserInfo;
import com.learnning.design_patterns.adapter_pattern.ObjectAdapter.IUserInfo;
import com.learnning.design_patterns.adapter_pattern.Target;
import org.junit.Test;

/**
 * 类 名 称：TestAdapterPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月25日
 */
public class TestAdapterPattern {
    @Test
    public void testAdapterPattern() {
        Target target1 = new ConcreateTarget();
        target1.request();
        System.out.println("引入适配器");
        Target target2 = new Adapter();
        target2.request();
    }

    @Test
    public void testObjectAdapter() {
        AdapteeHomeInfo homeInfo = new AdapteeHomeInfo();
        AdapteeOfficeInfo officeInfo = new AdapteeOfficeInfo();

        IUserInfo userInfo = new AdapterUserInfo(homeInfo, officeInfo);
        System.out.println("家庭住址：" + userInfo.getAddr());
        System.out.println("家庭电话：" + userInfo.getHomeTel());
        System.out.println("姓名：" + userInfo.getUserName());
        System.out.println("办公电话：" + userInfo.getOfficeTel());
    }
}
