package test;

import com.learnning.design_patterns.interpreter_pattern.Calc;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 类 名 称：TestInterpreter.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年09月24日
 */
public class TestInterpreter {
    @Test
    public void testInterpreter() {
        Calc calc = new Calc("a+b-c+d-e");
        Map<String, Integer> vars = new HashMap<String, Integer>();
        vars.put("a", 10);
        vars.put("b", 20);
        vars.put("c", 5);
        vars.put("d", 1);
        vars.put("e", 20);
        System.out.println(calc.calc(vars));
    }
}
