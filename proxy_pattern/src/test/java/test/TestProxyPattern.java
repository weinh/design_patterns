package test;

import com.learnning.design_patterns.proxy_pattern.RealSubject;
import com.learnning.design_patterns.proxy_pattern.Subject;
import com.learnning.design_patterns.proxy_pattern.definition.ProxySubject;
import com.learnning.design_patterns.proxy_pattern.dynamic.DynamicProxy;
import com.learnning.design_patterns.proxy_pattern.dynamic.Handler;
import com.learnning.design_patterns.proxy_pattern.dynamic.SubjectDynamicProxy;
import com.learnning.design_patterns.proxy_pattern.general.GeneralProxySubject;
import com.learnning.design_patterns.proxy_pattern.mandatory.MandatoryProxySubject;
import com.learnning.design_patterns.proxy_pattern.mandatory.MandatoryRealSubject;
import com.learnning.design_patterns.proxy_pattern.mandatory.MandatorySubject;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;

/**
 * 类 名 称：TestProxyPattern.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月10日
 */
public class TestProxyPattern {
    @Test
    public void testDefinition() {
        Subject subject = new RealSubject();
        Subject proxy = new ProxySubject(subject);
        proxy.exec();
    }

    @Test
    public void testGeneral() {
        Subject subject = new GeneralProxySubject();
        subject.exec();
    }

    @Test
    public void testMandatory1() {
        MandatorySubject realSubject = new MandatoryRealSubject();
        realSubject.exec();
    }

    @Test
    public void testMandatory2() {
        MandatorySubject realSubject = new MandatoryRealSubject();
        MandatorySubject proxySubject = new MandatoryProxySubject(realSubject);
        proxySubject.exec();
    }

    @Test
    public void testMandatory3() {
        MandatorySubject realSubject = new MandatoryRealSubject();
        MandatorySubject proxySubject = realSubject.getProxy();
        proxySubject.exec();
    }

    @Test
    public void testDynamic() {
        Subject subject = new RealSubject();
        Subject dynamicProxy = SubjectDynamicProxy.newProxyInstance(subject);
        dynamicProxy.exec();
    }
}
