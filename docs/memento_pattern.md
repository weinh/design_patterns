# 备忘录模式
## 定义
在不破坏封装性的前提下，捕获一个对象的内部状态，并在改对象之外保存该状态，这样以后就可将该对象恢复到原先保存的状态

我们来看下通用代码：
```java
public class Originator {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Memento createMemento() {
        return new Memento(status);
    }

    public void setMemento(Memento memento) {
        setStatus(memento.getStatus());
    }
}
```
捕获该对象的状态，除了状态属性外，还负责创建恢复备忘录类
```java
public class Memento {
    private String status;

    public Memento(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
```
再类外部保存状态，这个任务交给了备忘录类
```java
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
```
提供一个类，管理备忘录

单元测试
```
    @Test
    public void testMementoPattern() {
        Originator originator = new Originator();
        originator.setStatus("原始状态");
        System.out.println("起始状态：" + originator.getStatus());

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());

        originator.setStatus("变更后的状态");
        System.out.println("变更后的状态：" + originator.getStatus());

        originator.setMemento(caretaker.getMemento());
        System.out.println("恢复原始状态：" + originator.getStatus());

    }
```
测试结果
```
起始状态：原始状态
变更后的状态：变更后的状态
恢复原始状态：原始状态
```
以上是通用的备忘录模式，很简单，但是现实世界基本见不到这种，有很多变形，复杂的多
## 注意事项
* 备忘录的生命周期
>备忘录创建出来就要在最近的地方使用，主动管理它的生命周期，建立起来就使用，不使用就删除其引用，等待垃圾回收
* 备忘录的性能
>不要在频繁建立备份的场景使用备忘录模式，比如for循环，1、控制不了备忘录建立的对象，2、大对象的建立要消耗资源
## 扩展
### clone方式的备忘录
```java
public class Originator implements Cloneable {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Originator createMemento() {
        return this.clone();
    }

    public void restoreMemento(Originator originator) {
        setStatus(originator.getStatus());
    }

    @Override
    protected Originator clone() {
        try {
            return (Originator) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
public class Caretaker {
    private Originator originator;

    public Originator getOriginator() {
        return originator;
    }

    public void setOriginator(Originator originator) {
        this.originator = originator;
    }
}
```
程序将备忘录和对象合并了，实现了Cloneable接口，通过clone()方法实现备份

单元测试
```
    @Test
    public void testCloneMementoPattern() {
        Originator originator = new Originator();
        originator.setStatus("原始状态");
        System.out.println("原始状态：" + originator.getStatus());

        Caretaker caretaker = new Caretaker();
        caretaker.setOriginator(originator.createMemento());

        originator.setStatus("改变状态");
        System.out.println("变更后的状态：" + originator.getStatus());

        originator.restoreMemento(caretaker.getOriginator());
        System.out.println("恢复原始状态：" + originator.getStatus());
    }
```
测试结果
```
原始状态：原始状态
变更后的状态：改变状态
恢复原始状态：原始状态
```
既然备忘录类都被合并了，其实管理备忘录的类也能合并
```java
public class Originator2 implements Cloneable {
    private String status;

    private Originator2 backup;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void createMemento() {
        backup = this.clone();
    }

    public void restoreMemento() {
        setStatus(backup.getStatus());
    }

    @Override
    protected Originator2 clone() {
        try {
            return (Originator2) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
```
这个其实和定义不符，定义说在类以外的地方保存状态，其实设计模式的概念提出比java出世早好多，没想到java可以将对象封装到另外一个对象中

### 多状态的备忘录模式
```java
public class Originator {
    private String status1;
    private String status2;
    private String status3;

    public String getStatus1() {
        return status1;
    }

    public void setStatus1(String status1) {
        this.status1 = status1;
    }

    public String getStatus2() {
        return status2;
    }

    public void setStatus2(String status2) {
        this.status2 = status2;
    }

    public String getStatus3() {
        return status3;
    }

    public void setStatus3(String status3) {
        this.status3 = status3;
    }

    public Memento CreateMements() {
        return new Memento(BeanUtils.backupProp(this));
    }

    public void restoreMemento(Memento memento) {
        BeanUtils.restoreProp(this, memento.getStatusMap());
    }

    @Override
    public String toString() {
        return "status1=" + status1 + "，status2=" + status2 + "，status3=" + status3;
    }
}
```
定义了三个状态，创建备忘录的时候通过BeanUtils工具类转换为map，存入备忘录中，恢复的备忘录的时候将map转换为对象进行恢复
```java
public class Memento {
    private Map<String, Object> statusMap;

    public Memento(Map<String, Object> stringStringMap) {
        statusMap = stringStringMap;
    }

    public Map<String, Object> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, Object> statusMap) {
        this.statusMap = statusMap;
    }
}
```
多状态用map保存
```java
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
```
管理备忘录类
```java
public class BeanUtils {
    public static Map<String, Object> backupProp(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor prop[] = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : prop) {
                String fieldName = propertyDescriptor.getName();
                Method method = propertyDescriptor.getReadMethod();
                Object object = method.invoke(obj);
                if (!"class".equals(fieldName)) {
                    map.put(fieldName, object);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void restoreProp(Object obj, Map<String, Object> statusMap) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor prop[] = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : prop) {
                String fieldName = propertyDescriptor.getName();
                if (statusMap.containsKey(fieldName)) {
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(obj, new Object[]{statusMap.get(fieldName)});
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
```
BeanUtils工具类，用于转换对象和map的方法

单元测试
```
    @Test
    public void testMultiStatusMementoPattern(){
        Originator originator = new Originator();
        originator.setStatus1("原始状态1");
        originator.setStatus2("原始状态2");
        originator.setStatus3("原始状态3");
        System.out.println("原始状态："+originator);

        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.CreateMements());

        originator.setStatus1("变更状态1");
        originator.setStatus2("变更状态2");
        originator.setStatus3("变更状态3");
        System.out.println("变更状态："+originator);

        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态："+originator);
    }
```
测试结果
```
原始状态：status1=原始状态1，status2=原始状态2，status3=原始状态3
变更状态：status1=变更状态1，status2=变更状态2，status3=变更状态3
恢复状态：status1=原始状态1，status2=原始状态2，status3=原始状态3
```
### 多备忘录
前面讲的都只能备份一次
我们可以稍微调整下，管理备忘录的类使可以产生多次备份
```java
public class MultiCaretaker {
    private Map<String, Memento> map = new HashMap<String, Memento>();

    public void setMemento(String idx, Memento memento) {
        map.put(idx, memento);
    }

    public Memento getMemento(String idx) {
        return map.get(idx);
    }
}
```
单元测试
```
    @Test
    public void testMultiMementoPattern() {
        Originator originator = new Originator();
        originator.setStatus("原始状态");
        System.out.println("起始状态：" + originator.getStatus());

        MultiCaretaker caretaker = new MultiCaretaker();
        caretaker.setMemento("001", originator.createMemento());

        originator.setStatus("状态2");
        System.out.println("变更状态：" + originator.getStatus());
        caretaker.setMemento("002", originator.createMemento());

        originator.setMemento(caretaker.getMemento("001"));
        System.out.println("恢复到001状态——起始状态：" + originator.getStatus());

        originator.setMemento(caretaker.getMemento("002"));
        System.out.println("恢复到002状态——变更状态：" + originator.getStatus());
    }
```
测试结果
```
起始状态：原始状态
变更状态：状态2
恢复到001状态——起始状态：原始状态
恢复到002状态——变更状态：状态2
```
以上这种方式其实是有风险的，一旦创建了备份到map中，就没有被销毁的意向，建议map增加的时候设定一定的上限，否则将可能出现内存移出
### 封装的更好一点
很多备份后的内容为了安全，是不允许被修改的，只有发起人才能访问
```java
public interface IMemento {
}
public class Originator {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public IMemento createMemento() {
        return new Memento(status);
    }

    public void restoreMemento(IMemento memento) {
        setStatus(((Memento) memento).getStatus());
    }

    class Memento implements IMemento {

        private String status;

        public Memento(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
public class Caretaker {
    private IMemento memento;

    public IMemento getMemento() {
        return memento;
    }

    public void setMemento(IMemento memento) {
        this.memento = memento;
    }
}
```
定义备忘录接口，空接口，定义备忘录实现类为发起人的内部类，而且定义的实现类方法都是私有的方法，保证外部无法调用，当然没有绝对的安全，还是可以通过反射的方式设置可以访问权限达到调用的目的

以上的设计方法叫：双接口设计

我们的一个类可以实现多个接口，在系统设计时，如果考虑对象的安全问题，则可以提供两个接口，一个是业务的正常接口，实现必要的业务逻辑，叫做宽接口，另外一个接口是一个空接口，什么方法都没有，其目的是提供给子系统外的模块访问，比如容器对象，这个叫做窄接口，由于窄接口中没有提供任何操作数据的方法，因此相对来说比较安全