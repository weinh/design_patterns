package test.lsp.v2;

import com.learnning.design_patterns.lsp.v2.Father;
import com.learnning.design_patterns.lsp.v2.Son;
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
    public void testFather(){
        Father father = new Father();
        HashMap hashMap = new HashMap();
        father.doSomething(hashMap);
    }

    @Test
    public void testSon(){
        Son son = new Son();
        HashMap hashMap = new HashMap();
        son.doSomething(hashMap);
    }
}
