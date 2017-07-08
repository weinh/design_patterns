package test;

import com.learnning.design_patterns.builder_pattern.Kitchen;
import org.junit.Test;

/**
 * Created by weinh on 2017/7/8.
 */
public class TestBuilderPattern {
    @Test
    public void testBuilderPattern() {
        Kitchen kitchen = new Kitchen();
        kitchen.createTomatoAndEggSoup().show();
        kitchen.createTomatoScrambledEggs().show();
    }
}
