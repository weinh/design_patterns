import com.learnning.design_patterns.status_pattern.ConcreteStatus1;
import com.learnning.design_patterns.status_pattern.Context;
import com.learnning.design_patterns.status_pattern.Status;
import org.junit.Test;

/**
 * 类 名 称：TestStatusPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月13日
 */
public class TestStatusPattern {
    @Test
    public void testStatusPattern() {
        Context context = new Context();
        context.setCurrentStatus(new ConcreteStatus1());
        context.handleStatus1();
        context.handleStatus2();
    }
}
