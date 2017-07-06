package test;

import com.learnning.design_patterns.factory_method_pattern.Product;
import com.learnning.design_patterns.factory_method_pattern.ProductA;
import com.learnning.design_patterns.factory_method_pattern.ProductB;
import com.learnning.design_patterns.factory_method_pattern.factory_method.AbstractFactory;
import com.learnning.design_patterns.factory_method_pattern.factory_method.Factory;
import com.learnning.design_patterns.factory_method_pattern.lazy_init.LazyInitFactory;
import com.learnning.design_patterns.factory_method_pattern.multiple_factory.FactoryA;
import com.learnning.design_patterns.factory_method_pattern.multiple_factory.FactoryB;
import com.learnning.design_patterns.factory_method_pattern.simple_factory.SimpleFactory;
import com.learnning.design_patterns.factory_method_pattern.singleton.Singleton;
import com.learnning.design_patterns.factory_method_pattern.singleton.SingletonFactory;
import org.junit.Test;

/**
 * 类 名 称：TestFactoryMethod.java
 * 功能说明：
 * 开发人员：weinh
 * 开发时间：2017年07月06日
 */
public class TestFactoryMethod {

    @Test
    public void testFactoryMethod() {
        AbstractFactory factory = new Factory();
        Product productA = factory.createProduct(ProductA.class);
        productA.introduce();
        Product productB = factory.createProduct(ProductB.class);
        productB.introduce();
    }

    @Test
    public void testSimpleFactory() {
        Product productA = SimpleFactory.createProduct(ProductA.class);
        productA.introduce();
        Product productB = SimpleFactory.createProduct(ProductB.class);
        productB.introduce();
    }

    @Test
    public void testMultipleFactory() {
        Product productA = (new FactoryA()).createProduct();
        productA.introduce();
        Product productB = (new FactoryB()).createProduct();
        productB.introduce();
    }

    @Test
    public void testSingletonByFactory() {
        Singleton singleton = SingletonFactory.getSingleton();
        singleton.introduce();
    }

    @Test
    public void testLazyInitFactory() {
        Product productA = LazyInitFactory.createProduct("productA");
        productA.introduce();
        Product productB = LazyInitFactory.createProduct("productB");
        productB.introduce();
    }
}
