package test;

import com.learnning.design_patterns.flyweight_pattern.FlyweightFactory;
import org.junit.Test;

/**
 * 类 名 称：TestFlyweight.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月25日
 */
public class TestFlyweight {
    @Test
    public void testFlyweight() {
        for (int i = 1; i <= 5; i++) {
            String nianji = i + "年";
            for (int j = 1; j <= 5; j++) {
                String extrinsic = nianji + j + "班";
                FlyweightFactory.getFlyweight(extrinsic);
            }
        }
        FlyweightFactory.getFlyweight("1年3班");
    }
}
