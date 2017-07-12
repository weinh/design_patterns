package test;

import com.learnning.design_patterns.chain_responsibility_pattern.AbstractHandler;
import com.learnning.design_patterns.chain_responsibility_pattern.Handler1;
import com.learnning.design_patterns.chain_responsibility_pattern.Handler2;
import com.learnning.design_patterns.chain_responsibility_pattern.Request;
import com.learnning.design_patterns.chain_responsibility_pattern.Response;
import org.junit.Test;

/**
 * 类 名 称：TestChain.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月13日
 */
public class TestChain {
    @Test
    public void testChain() {
        Request request = new Request();
        AbstractHandler handler1 = new Handler1();
        AbstractHandler handler2 = new Handler2();

        handler1.setNextHandler(handler2);
        Response response = handler1.handlerMessage(request);
    }
}
