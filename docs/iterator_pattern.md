# 迭代器模式
## 定义
它提供一种方法访问一个容器对象的各个元素，而又不需要暴露该对象的内部细节

我们来看下通用代码
```java
public interface Iterator {
    Object next();

    boolean hasNext();

    boolean remove();
}
public class ConcreteIterator implements Iterator {
    private Vector vector = new Vector();
    private int cursor = 0;

    public ConcreteIterator(Vector vector) {
        this.vector = vector;
    }

    public Object next() {
        if (hasNext()) {
            return vector.get(cursor++);
        } else {
            return null;
        }
    }

    public boolean hasNext() {
        return cursor != vector.size();
    }

    public boolean remove() {
        vector.remove(cursor);
        return true;
    }
}
```
定义一个迭代器接口，实现该迭代器接口，一般迭代器有三个方法，next，hasNext，remove
```java
public interface Aggregate {
    void add(Object object);

    void remove(Object object);

    Iterator iterator();
}
public class ConCreteAggregate implements Aggregate {
    private Vector vector = new Vector();

    public void add(Object object) {
        vector.add(object);
    }

    public void remove(Object object) {
        vector.remove(object);
    }

    public Iterator iterator() {
        return new ConcreteIterator(vector);
    }
}
```
定义一个容器，实现一个容器接口，通常复杂元素的添加，删除，还有一个就是获取迭代器

单元测试
```
    @Test
    public void testIteratorPattern() {
        Aggregate aggregate = new ConCreteAggregate();
        aggregate.add("1");
        aggregate.add("2");
        aggregate.add("3");
        Iterator iterator = aggregate.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
```
测试结果
```
1
2
3
```
迭代器模式都快被淘汰了，因为太老了，而且java已经把它作为基础包，很多容器都实现了Iterable接口，可以拿到迭代器对象
