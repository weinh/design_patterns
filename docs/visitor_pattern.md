# 访问者模式
## 定义
封装一些作用于某种数据结构中的各元素的操作，它可以在不改变数据结构的前提下定义作用于这些元素的新的操作

下面我们看下通用代码
```java
public interface IVisitor {
    void visitor(Element element);

    void visitor(Element1 element);
}
public class Visitor implements IVisitor {

    public void visitor(Element element) {
        System.out.println("我是Element：" + element.doSomething() + "的访问者");
    }

    public void visitor(Element1 element) {
        System.out.println("我是Element1：" + element.doSomething() + "的访问者");
    }

}
```
定义访问者，定义需要访问那些元素
```java
public interface IElement {
    void accept(IVisitor visitor);

    String doSomething();
}
public class Element implements IElement {
    private String name;

    public Element(String name) {
        this.name = name;
    }

    public void accept(IVisitor visitor) {
        visitor.visitor(this);
    }

    public String doSomething() {
        return name;
    }
}
public class Element1 implements IElement {
    private String name;

    public Element1(String name) {
        this.name = name;
    }

    public void accept(IVisitor visitor) {
        visitor.visitor(this);
    }

    public String doSomething() {
        return name;
    }
}
```
定义数据结构，里面有需要操作的元素，void accept(IVisitor visitor);方法将会指定某个访问者，实现类一般会调用visitor.visitor(this);

单元测试
```
    @Test
    public void testVisitorPattern() {
        List<IElement> list = new ArrayList<IElement>();
        IElement elementA = new Element("a");
        IElement elementB = new Element1("b");
        IElement elementC = new Element("c");
        IElement elementD = new Element1("d");
        list.add(elementA);
        list.add(elementB);
        list.add(elementC);
        list.add(elementD);
        for (IElement element : list) {
            element.accept(new Visitor());
        }
    }
```
测试结果
```
我是Element：a的访问者
我是Element1：b的访问者
我是Element：c的访问者
我是Element1：d的访问者
```
## 优点
* 符合单一原则，Element负责加载数据，Visitor负责展现数据
* 优秀的扩展性，根据需求可以在访问者中增加一个方法达到目的
* 灵活性很高
## 缺点
* 具体元素对访问者公布细节，访问者需要展示计算数据，需要了解内部细节，不符合迪米特法则
* 具体元素变更比较困难，数据结构中需要增加一个元素，那么访问者需要对应的调整，如果访问者很多那么问题将很大
* 违背了依赖倒置原则，访问者依赖于具体的数据结构
## 扩展
* 统计功能，
* 多个访问者，很多数据要通过不同维度展示出来才能准确分析具体原因，那么访问者模式是很好的选择
* 双分派
