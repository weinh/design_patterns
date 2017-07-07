# 抽象工厂模式
## 定义
为创建一组相关或相互依赖的对象提供一个接口，而且无须指定它们的具体实现类。

先来看下通用代码：

一组相关或依赖的对象
```java
public abstract class AbstractProductA {
    public abstract void introduce();
}
public abstract class AbstractProductB {
    public abstract void introduce();
}
public class ProductA1 extends AbstractProductA {
    public void introduce() {
        System.out.println("我是ProductA1");
    }
}
public class ProductB1 extends AbstractProductB {
    public void introduce() {
        System.out.println("我是ProductB1");
    }
}
public class ProductA2 extends AbstractProductA {
    public void introduce() {
        System.out.println("我是ProductA2");
    }
}
public class ProductB2 extends  AbstractProductB {
    public void introduce() {
        System.out.println("我是ProductB2");
    }
}
```
提供一个接口，无须指定具体类
```java
public abstract class AbstractFactory {
    public abstract AbstractProductA createProductA();

    public abstract AbstractProductB createProductB();
}
public class Factory1 extends AbstractFactory {
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}
public class Factory2 extends AbstractFactory {
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
```
单元测试
```
    @Test
    public void testAbstractFactory() {
        AbstractFactory abstractCreator1 = new Factory1();
        AbstractFactory abstractCreator2 = new Factory2();

        AbstractProductA productA1 = abstractCreator1.createProductA();
        productA1.introduce();
        AbstractProductB productB1 = abstractCreator1.createProductB();
        productB1.introduce();

        AbstractProductA productA2 = abstractCreator2.createProductA();
        productA2.introduce();
        AbstractProductB productB2 = abstractCreator2.createProductB();
        productB2.introduce();
    }
```
测试结果
```
我是ProductA1
我是ProductB1
我是ProductA2
我是ProductB2
```
## 优点
* 封装性，高层模块无须关心产品实现类
* 产品族内的约束为非公开状态
## 缺点
* 产品族的扩展比较困难，虚高需要新增一个产品ProductC，需要修改AbstractFactory以及子类

如果是扩展产品等级，比如增加Product3的话是很方便的，从这个角度看是符合开闭原则的。