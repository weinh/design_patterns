# 代理模式（委托模式）
## 定义
为其他对象提供一种代理以控制对这个类的访问

先看下代理模式的通用代码

被代理对象
```java
public interface Subject {
    void exec();
}
public class RealSubject implements Subject {
    public void exec() {
        System.out.println("真实对象表演ing");
    }
}
```
代理类
```java
public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void exec() {
        before();
        subject.exec();
        after();
    }

    private void before() {
        System.out.println("节目开始");
    }

    private void after() {
        System.out.println("节目结束");
    }
}
```
单元测试
```
    @Test
    public void testGeneric() {
        Subject subject = new RealSubject();
        Subject proxy = new ProxySubject(subject);
        proxy.exec();
    }
```
测试结果
```
节目开始
真实对象表演ing
节目结束
```
## 优点
* 职责清晰，被代理对象只要干自己本职工作，其他工作，比如事务，日志交给代理对象完成
* 高扩展性，被代理对象实现了接口，无论如何修改，代理类不需要跟着变动
* 智能化，后面将会讲到，动态代理具备的特性

## 扩展
### 普通代理
普通代码，我们需要知道代理的存在，被代理类不能自己调用，代码如下
```java
public class GeneralRealSubject implements Subject {

    public GeneralRealSubject(Subject proxy) {
        if (proxy == null) {
            new RuntimeException("不能创建对象");
        }
    }

    public void exec() {
        System.out.println("普通代理的表演ing");
    }
}
public class GeneralProxySubject implements Subject {
    private Subject subject;

    public GeneralProxySubject() {
        subject = new GeneralRealSubject(this);
    }

    public void exec() {
        before();
        subject.exec();
        after();
    }

    private void before() {
        System.out.println("节目开始");
    }

    private void after() {
        System.out.println("节目结束");
    }
}
```
真实对象不能自己创建，并调用自己，需要依靠代理对象
单元测试
```
    @Test
    public void testGeneral(){
        Subject subject = new GeneralProxySubject();
        subject.exec();
    }
```
测试结果
```
节目开始
普通代理的表演ing
节目结束
```
### 强制代理
强制代理，我们不关心代理是否存在，代理的产生由真实类决定，比如A向B拿东西，B会说去找我秘书C，代码如下
```java
public interface MandatorySubject {
    void exec();
    MandatorySubject getProxy();
}
```
多了一个getProxy方法用于，获取代理类
```java
public class MandatoryRealSubject implements MandatorySubject {

    private MandatorySubject proxy = null;

    public MandatoryRealSubject() {

    }

    public MandatorySubject getProxy() {
        proxy = new MandatoryProxySubject(this);
        return proxy;
    }

    public void exec() {
        if (isProxy()) {
            System.out.println("强制代理的表演ing");
        } else {
            System.out.println("要看表演，先联系我的经纪人");
        }
    }

    private boolean isProxy() {
        return proxy != null;
    }
}
public class MandatoryProxySubject implements MandatorySubject {

    private MandatorySubject subject;

    public MandatoryProxySubject(MandatorySubject target) {
        this.subject = target;
    }

    public void exec() {
        before();
        subject.exec();
        after();
    }

    public MandatorySubject getProxy() {
        return this;
    }

    private void before() {
        System.out.println("节目开始");
    }

    private void after() {
        System.out.println("节目结束");
    }
}
```
看下单元测试
```
    @Test
    public void testMandatory1(){
        MandatorySubject realSubject = new MandatoryRealSubject();
        realSubject.exec();
    }

    @Test
    public void testMandatory2(){
        MandatorySubject realSubject = new MandatoryRealSubject();
        MandatorySubject proxySubject = new MandatoryProxySubject(realSubject);
        proxySubject.exec();
    }

    @Test
    public void testMandatory3(){
        MandatorySubject realSubject = new MandatoryRealSubject();
        MandatorySubject proxySubject = realSubject.getProxy();
        proxySubject.exec();
    }
```
这里有三个单元测试，我们分别看下结果
```
//testMandatory1
要看表演，先联系我的经纪人

//testMandatory2
节目开始
要看表演，先联系我的经纪人
节目结束

//testMandatory3
节目开始
强制代理的表演ing
节目结束
```
我们来解释下结果，第一个因为没有使用代理所以不表演，第二个因为代理不是真实对象的代理，随便找个经纪人我当然不干了，第三个成功了

## 动态代理
以上讲的可以归类为静态代理，下面我们来说下动态代理

动态代理就是在实现阶段不用关心代理谁，而在运行阶段才指定代理哪一个对象。

被代理对象以及其接口不变
```java
public class Handler implements InvocationHandler {

    private Object object;

    public Handler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        new BeforeAdvice().before();
        return method.invoke(object, args);
    }
}
public class DynamicProxy<T> {
    public static <T> T newProxyInstance(ClassLoader cl, Class<?>[] interfaces, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(cl, interfaces, handler);
    }
}
```
增强操作定义如下
```java
public interface IAdvice {
    void before();
}
public class BeforeAdvice implements IAdvice {
    public void before() {
        System.out.println("音乐。。。");
    }
}
```
弄一个更有意义的代理对象，方便客户端调用
```java
public class SubjectDynamicProxy extends DynamicProxy {
    public static <T> T newProxyInstance(Subject subject) {
        ClassLoader cl = subject.getClass().getClassLoader();
        Class<?> interfaces[] = subject.getClass().getInterfaces();
        InvocationHandler handler = new Handler(subject);
        return newProxyInstance(cl, interfaces, handler);
    }
}
```
单元测试
```
    @Test
    public void testDynamic() {
        Subject subject = new RealSubject();
        Subject dynamicProxy = SubjectDynamicProxy.newProxyInstance(subject);
        dynamicProxy.exec();
    }
```
测试结果
```
音乐。。。
真实对象表演ing
```
要是用动态代理必须实现一个接口，不过如果通过CGLIB也可以对那些没有实现接口的类进行动态代理
