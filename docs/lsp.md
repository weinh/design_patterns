# 里氏替换原则
## 定义
A is B
>父类出现的地方可以无感的替换成子类

## 前置条件（输入参数）
里氏替换原则为继承（extends）定了一个规范

面向对象有三大特性：封装性，继承性，多态性，其中多态性又分重写（覆盖或者覆写）和重载

下面我们来看下重载（overload）和重写（override）

定义一个类Father：
```java
public class Father {
    public Collection doSomething(HashMap map) {
        System.out.println("父类被执行");
        return map.values();
    }
}
```
在定义一个子类Son：
```java
public class Son extends Father {
    //Overload，重载
    public Collection doSomething(Map map) {
        System.out.println("子类被执行");
        return map.values();
    }
}
```
通过观察可以发现Son的doSomething方法是重载了Father的doSomething方法，因为输入参数（前置条件）不一致

我们通过测试类看下Father和Son的定义是否符合里氏替换原则
```
    @Test
    public void testOverloadFather(){
        Father father = new Father();
        HashMap map = new HashMap();
        father.doSomething(map);
    }
```
执行结果：
```
父类被执行
```
根据定义将父类替换成子类在测试
```
    @Test
    public void testOverloadSon(){
        Son son = new Son();
        HashMap map = new HashMap();
        son.doSomething(map);
    }
```
执行的结果是相同的，说明了什么，子类只是重载了doSomething方法没有覆盖，没有执行的子类的方法是正确的

我们观察下父子类的doSomething的区别，子类的参数比父类的参数更宽松

我们尝试下定义一个方法子类参数比父类严格的重载方法看看，看代码：
```java
public class Father {
    public Collection doSomething(Map map){
        System.out.println("父类被执行");
        return map.values();
    }
}
public class Son extends Father {
    public Collection doSomething(HashMap map){
        System.out.println("子类被执行");
        return map.values();
    }
}
```
我们还是用单元测试看下结果
```
    @Test
    public void testFather(){
        Father father = new Father();
        HashMap hashMap = new HashMap();
        father.doSomething(hashMap);
    }
```
返回结果
```
父类被执行
```
按照里氏替换原则把父类替换成子类看下结果
```
    @Test
    public void testSon(){
        Son son = new Son();
        HashMap hashMap = new HashMap();
        son.doSomething(hashMap);
    }
```
返回结果
```
子类被执行
```
发现替换成子类后执行的结果不一样了，替换后结果混乱了

所以要求子类中的方法输入参数必须比父类的一致或者宽松

上面讲的都是输入参数（前置条件），下面看下后置条件（输出参数）
## 后置条件（输出参数）
我们定义一个Father：
```java
public class Father {
    public List doSomething(HashMap map){
        System.out.println("父类被执行");
        return null;
    }
}
```
在定义一个子类Son：
```java
public class Son extends Father {

    /**
     * 该方法覆盖了父类的方法，可是这种写法是错误的，
     * 子类的返回类型的范围必须比父类的小
     *
     * @param hashMap
     * @return
     */
//    public Collection doSomething(HashMap hashMap) {
//        return null;
//    }

    /**
     * 覆盖（覆写）方法，返回类型范围必须比父类的小，语法的要求
     *
     * @param hashMap
     * @return
     */
    @Override
    public ArrayList doSomething(HashMap hashMap) {
        return null;
    }

    /**
     * 重载方法 overload
     *
     * @param map
     * @return
     */
    public Collection doSomething(Map map) {
        return null;
    }
}
```
方法名一致，输入参数一致则为重写（覆盖或覆写），java要求重写的情况下，子类的后置条件（输出参数）比父类的范围小，否则就报错了
```
public Collection doSomething(HashMap hashMap)
```
这种情况是不被允许的

通过以上几个例子相信大家对里氏替换原则有一定的认识了