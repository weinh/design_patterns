# 原型模式
## 定义
用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。

原型模式很简单，就是实现Cloneable接口，然后重写clone方法
```java
public class PrototypeClass implements Cloneable {
    private String name;

    public PrototypeClass(String name) {
        System.out.println("构造方法执行");
        this.name = name;
    }

    @Override
    public PrototypeClass clone() throws CloneNotSupportedException {
        return (PrototypeClass) super.clone();
    }

    public void show() {
        System.out.println("我是" + name);
    }
}
```
单元测试
```
    @Test
    public void testPrototype() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = new PrototypeClass("美猴王");
        prototypeClass.show();

        PrototypeClass cloneClass = (PrototypeClass) prototypeClass.clone();
        cloneClass.show();
    }
```
测试结果
```
我是美猴王
我是美猴王
```
## 优点
* 性能优良，原型模型是通过内存直接拷贝二进制流，比通过new性能好很多
* 逃避构造函数的约束，这也是它的缺点，直接的内存拷贝不会执行构造方法

写个例子，验证下原型模式构造函数不会被执行，代码还是刚刚的原型类，换个单元测试
```
    @Test
    public void testConstructor() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = new PrototypeClass("美猴王");
        PrototypeClass cloneClass = prototypeClass.clone();
    }
```
测试结果
```
构造方法执行
```
## 浅拷贝和深拷贝
讲解前先看一段代码吧
```java
public class CopyAny implements Cloneable {
    private List<String> list = new ArrayList<String>();

    @Override
    public CopyAny clone() throws CloneNotSupportedException {
        return (CopyAny) super.clone();
    }

    public void setList(String name) {
        list.add(name);
    }

    public void show() {
        System.out.println(list);
    }
}
```
单元测试
```
    @Test
    public void testCopy() throws CloneNotSupportedException {
        CopyAny copyAny = new CopyAny();
        copyAny.setList("二郎神");

        CopyAny copyAny1 = copyAny.clone();
        copyAny1.setList("哪吒");

        copyAny.show();
    }
```
测试结果
```
[二郎神, 哪吒]
```
发现了没有，多了个“哪吒”，这是因为java做了偷懒的动作，对于那些非基本类型的数据没有拷贝，只是指向了同一个内存空间，导致克隆出来的对象可以改原始对象的数据内容吗，这就是浅拷贝了

对于String类型的字段java做了特殊处理，可以当做基本类型来使用

那么怎么处理才可以变深拷贝呢
```java
public class DeepCopy implements Cloneable {
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    public DeepCopy clone() throws CloneNotSupportedException {
        DeepCopy deepCopy = (DeepCopy) super.clone();
        deepCopy.list = (ArrayList<String>) this.list.clone();
        return deepCopy;
    }

    public void setList(String name) {
        list.add(name);
    }

    public void show() {
        System.out.println(list);
    }
}
```
需要将非基本类型的字段单独拷贝才有效果

单元测试
```
    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        DeepCopy deepCopy = new DeepCopy();
        deepCopy.setList("二郎神");

        DeepCopy deepCopy1 = deepCopy.clone();
        deepCopy1.setList("哪吒");

        deepCopy.show();
        deepCopy1.show();
    }
```
测试结果
```
[二郎神]
[二郎神, 哪吒]
```
## clone和final
使用final关键字修饰的字段是无法进行拷贝的

代码如下

```java
public class FinalCopy implements Cloneable {
    private final ArrayList<String> list = new ArrayList<String>();

    @Override
    public FinalCopy clone() throws CloneNotSupportedException {
        FinalCopy finalCopy = (FinalCopy) super.clone();
//        finalCopy.list = (ArrayList<String>) this.list.clone();
        return finalCopy;
    }

    public void setList(String name) {
        list.add(name);
    }

    public void show() {
        System.out.println(list);
    }
}
```
注释掉那句话如果要想用，需要去掉final关键字