package test;

import com.learnning.design_patterns.template_method_pattern.AbstractTemplate;
import com.learnning.design_patterns.template_method_pattern.Template1;
import com.learnning.design_patterns.template_method_pattern.Template2;
import org.junit.Test;

/**
 * 类 名 称：TestTemplateMethod.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月07日
 */
public class TestTemplateMethod {
    @Test
    public void testTemplateMethod() {
        AbstractTemplate template1 = new Template1();
        template1.templateMethod();

        AbstractTemplate template2 = new Template2();
        template2.templateMethod();
    }
}
