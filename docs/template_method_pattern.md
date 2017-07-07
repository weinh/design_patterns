# 模板方法模式
## 定义
定义一个操作中的算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重新定义该算法的某些特定步骤

看下通用代码：

抽象模板
```java
public abstract class AbstractTemplate {
    /**
     * 定义基础方法为protected类型，符合迪米特法则
     */
    protected abstract void baseMethod1();

    protected abstract void baseMethod2();

    protected abstract void baseMethod3();

    /**
     * 为了防止搞破坏，将模板方法定义为final类型
     */
    public final void templateMethod() {
        baseMethod1();
        baseMethod2();
        baseMethod3();
    }
}
```
具体子类
```java
public class Template1 extends AbstractTemplate {
    /**
     * 没有特殊情况，子类覆盖的方法不会扩大访问范围
     */
    protected void baseMethod1() {
        System.out.println("模板1——步骤1");
    }

    protected void baseMethod2() {
        System.out.println("模板1——步骤2");
    }

    protected void baseMethod3() {
        System.out.println("模板1——步骤3");
    }
}
public class Template2 extends AbstractTemplate {
    protected void baseMethod1() {
        System.out.println("模板2——步骤1");
    }

    protected void baseMethod2() {
        System.out.println("模板2——步骤2");
    }

    protected void baseMethod3() {
        System.out.println("模板2——步骤3");
    }
}
```
单元测试
```
    @Test
    public void testTemplateMethod() {
        AbstractTemplate template1 = new Template1();
        template1.templateMethod();

        AbstractTemplate template2 = new Template2();
        template2.templateMethod();
    }
```
测试结果
```
模板1——步骤1
模板1——步骤2
模板1——步骤3
模板2——步骤1
模板2——步骤2
模板2——步骤3
```
## 优点
* 封装不变部分，扩展可变部分
* 提取公共部分代码，便于维护
* 行为由父类控制，之类实现
## 缺点
按照习惯，一般定义抽象类为属性和方法，具体实现由子类完成，模板方法模式颠倒了，导致子类的执行的结果影响了父类的结果
