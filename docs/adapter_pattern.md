# 适配器模式（变压器模式，包装模式）
## 定义
将一个类的接口变换成客户端期待的另一种接口，从而使原本因接口不匹配而无法在一起工作的两个类能够在一起工作。

我们来看下通用代码
```java
public interface Target {
    void request();
}
public class ConcreateTarget implements Target {
    public void request() {
        System.out.println("目标对象实现");
    }
}
```
定义目标对象，通常目标对象是接口或者抽象类
```java
public class Adaptee {
    public void dosomething() {
        System.out.println("源对象处理");
    }
}
```
定义源对象
```java
public class Adapter extends Adaptee implements Target {
    public void request() {
        super.dosomething();
    }
}
```
定义适配器，通过继承的方式处理

单元测试
```
        Target target1 = new ConcreateTarget();
        target1.request();
        System.out.println("引入适配器");
        Target target2 = new Adapter();
        target2.request();
```
测试结果
```
目标对象实现
引入适配器
源对象处理
```
## 优点
* 适配器模式可以让两个没有任何关系的类一起运行
* 增加了类的透明性
* 提高了类的复用度
* 灵活性好

## 注意事项
在详细设计阶段不要考虑适配器模式，项目一定要遵守倒置依赖原则和里氏替换原则，否则后期需要使用适配器模式，需要进行非常大的改造工作

## 扩展
比如有一种场景，有三个源，目标只有一个，那么怎么使用适配器模式呢，看下代码
```java
public interface IUserInfo {
    String getUserName();

    String getAddr();

    String getOfficeTel();

    String getHomeTel();
}
```
目标对象
```java
public class AdapteeHomeInfo {
    public Map<String, String> getHomeInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("homeTel", "0000");
        map.put("userName", "老三");
        map.put("addr", "杭州");
        return map;
    }
}
public class AdapteeOfficeInfo {
    public Map<String, String> getOfficeInfo() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("officeTel", "1111");
        return map;
    }
}
```
多个源对象
```java
public class AdapterUserInfo implements IUserInfo {

    private AdapteeHomeInfo homeInfo;
    private AdapteeOfficeInfo officeInfo;

    public AdapterUserInfo(AdapteeHomeInfo homeInfo, AdapteeOfficeInfo officeInfo) {
        this.homeInfo = homeInfo;
        this.officeInfo = officeInfo;
    }

    public String getUserName() {
        return homeInfo.getHomeInfo().get("userName");
    }

    public String getAddr() {
        return homeInfo.getHomeInfo().get("addr");
    }

    public String getOfficeTel() {
        return officeInfo.getOfficeInfo().get("officeTel");
    }

    public String getHomeTel() {
        return homeInfo.getHomeInfo().get("homeTel");
    }
}
```
适配对象

单元测试
```
        AdapteeHomeInfo homeInfo = new AdapteeHomeInfo();
        AdapteeOfficeInfo officeInfo = new AdapteeOfficeInfo();

        IUserInfo userInfo = new AdapterUserInfo(homeInfo, officeInfo);
        System.out.println("家庭住址：" + userInfo.getAddr());
        System.out.println("家庭电话：" + userInfo.getHomeTel());
        System.out.println("姓名：" + userInfo.getUserName());
        System.out.println("办公电话：" + userInfo.getOfficeTel());
```
测试结果
```
家庭住址：杭州
家庭电话：0000
姓名：老三
办公电话：1111
```
由于java是单继承的，无法同时继承多个源，使用聚合的方式让适配器和源产生联系，将对象通过构造函数传进来，所以我们叫这个为对象适配，前面讲的通过继承实现的适配叫类适配器