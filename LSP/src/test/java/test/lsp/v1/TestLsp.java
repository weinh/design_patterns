package test.lsp.v1;

import com.learnning.design_patterns.lsp.v1.Father;
import com.learnning.design_patterns.lsp.v1.Son;
import org.junit.Test;

import java.util.HashMap;

/**
 * 类 名 称：TestLsp.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月04日
 */
public class TestLsp {

    @Test
    public void testOverloadFather(){
        Father father = new Father();
        HashMap map = new HashMap();
        father.doSomething(map);
    }

    @Test
    public void testOverloadSon(){
        Son son = new Son();
        HashMap map = new HashMap();
        son.doSomething(map);
    }
}
