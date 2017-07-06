# 工厂方法模式
## 定义
一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到其子类

看下代码如下：

抽象工厂类
```java
public abstract class AbstractFactory {
    public abstract <T extends Product> T createProduct(Class clazz);
}
```
工厂子类
```java
public class Factory extends AbstractFactory {
    public  <T extends Product> T createProduct(Class clazz) {
        Product product = null;
        try {
            product = (T) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("创建产品出错");
        }
        return (T) product;
    }
}
```
产品接口类
```java
public interface Product {
    void introduce();
}
```
产品实现类：产品A
```java
public class ProductA implements Product {
    public void introduce() {
        System.out.println("我的产品A");
    }
}
```
产品实现类：产品B
```java
public class ProductB implements Product {
    public void introduce() {
        System.out.println("我是产品B");
    }
}
```
单元测试一下
```
    @Test
    public void testFactoryMethod() {
        AbstractFactory factory = new Factory();
        Product productA = factory.createProduct(ProductA.class);
        productA.introduce();
        Product productB = factory.createProduct(ProductB.class);
        productB.introduce();
    }
```
测试结果
```
我的产品A
我是产品B
```
## 优点
* 良好的封装性，代码结构清晰
* 扩展性非常优秀
* 屏蔽产品类，类似JDBC，不需要关心高层应用使用的是那个数据库，如果现在是mysql需要替换成Oracle，只需要修改下数据库渠道就OK
* 一个解耦框架，高层只需要知道产品的抽象类，符合迪米特法则，也符合依赖倒置法则，依赖抽象，还符合里氏替换原则，产品子类可以替换产品父类

## 工厂方法模式的扩展
### 简单工厂模式（静态工厂模式）
简单工厂模式，就是简化了工厂方法，去掉了抽象接口，将子类工厂方法设定为静态方法
```java
public class SimpleFactory {
    public static <T extends Product> T createProduct(Class clazz) {
        Product product = null;
        try {
            product = (T) Class.forName(clazz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("创建产品出错");
        }
        return (T) product;
    }
}
```
单元测试
```
    @Test
    public void testSimpleFactory() {
        Product productA = SimpleFactory.createProduct(ProductA.class);
        productA.introduce();
        Product productB = SimpleFactory.createProduct(ProductB.class);
        productB.introduce();
    }
```
测试结果
```
我的产品A
我是产品B
```
### 多个工厂类
将工厂进行拆分，每创建一个产品使用一个工厂方法

抽象工厂类，定义创建产品的方法无需关心约束细节
```java
public abstract class AbstractMultipleFactory {
    public abstract Product createProduct();
}
```
创建产品A的工厂类
```java
public class FactoryA extends AbstractMultipleFactory {
    public Product createProduct() {
        return new ProductA();
    }
}
```
创建产品B的工厂类
```java
public class FactoryB extends AbstractMultipleFactory {
    public Product createProduct() {
        return new ProductB();
    }
}
```
单元测试
```
    @Test
    public void testMultipleFactory() {
        Product productA = (new FactoryA()).createProduct();
        productA.introduce();
        Product productB = (new FactoryB()).createProduct();
        productB.introduce();
    }
```
测试结果
```
我的产品A
我是产品B
```
这种方式，如果需要扩展就比较麻烦，需要定义产品子类的同时，还需要创建对应的工厂方法
### 替代单例模式
可以使用工厂方法，模拟实现单例模式

需要创建单例的类，构造方法设定为private
```java
public class Singleton {
    private Singleton() {
    }

    public void introduce() {
        System.out.println("我是单例");
    }
}
```
用于创建单例的工厂方法
```java
public class SingletonFactory {
    private static Singleton singleton;

    static {
        try {
            Class clazz = Class.forName(Singleton.class.getName());
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);//设定构造方法是可以访问的
            singleton = (Singleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("使用工厂方法创建单例出错");
        }
    }

    public static Singleton getSingleton() {
        return singleton;
    }
}
```
单元测试
```
    @Test
    public void testSingletonByFactory() {
        Singleton singleton = SingletonFactory.getSingleton();
        singleton.introduce();
    }
```
测试结果
```
我是单例
```
### 延迟初始化
一个对象被消费后，并不立即被释放，工厂类保持其初始化状态，等待再次被使用

延迟初始化类，保存已经创建过实例供后面有需要的时候使用
```java
public class LazyInitFactory {
    private final static Map<String, Product> products = new HashMap<String, Product>();

    public synchronized static Product createProduct(String type) {
        Product product = null;
        if (products.containsKey(type)) {
            product = products.get(type);
        } else {
            if ("productA".equals(type)) {
                product = new ProductA();
            } else {
                product = new ProductB();
            }
            products.put(type, product);
        }
        return product;
    }
}
```
单元测试
```
    @Test
    public void testLazyInitFactory() {
        Product productA = LazyInitFactory.createProduct("productA");
        productA.introduce();
        Product productB = LazyInitFactory.createProduct("productB");
        productB.introduce();
    }
```
测试结果
```
我的产品A
我是产品B
```
如果该方案增加一个最大实例的限制，通过该值判断map已有的数量，这种就类似数据库连接池的最大连接数