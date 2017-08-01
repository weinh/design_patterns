# 组合模式（合成模式，部分-整体模式）
## 定义
将对象组合成树形结构以表示“整体-部分”的层次结构，使得用户对单个对象或组合对象的使用具有一致性

下面我们看下通用代码
```java
public abstract class Component {
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("我是" + name);
    }
}
```
定义一个根节点，树枝节点，树叶节点都有共性的抽象类
```java
public class Composite extends Component {
    private List<Component> componentList = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }

    public void add(Component component) {
        componentList.add(component);
    }

    public void remove(Component component) {
        componentList.remove(component);
    }

    public List<Component> getChildren() {
        return componentList;
    }
}
```
实现为根节点或者树枝节点，可以添加其他树枝节点或树叶节点
```java
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }
}
```
树叶节点

单元测试
```
    @Test
    public void testCompositePattern() {
        Composite root = new Composite("根节点");
        root.show();
        Composite branch = new Composite("树枝节点");
        Leaf leaf = new Leaf("树叶节点");
        root.add(branch);
        branch.add(leaf);

        display(root);
    }

    private void display(Composite root) {
        for (Component c : root.getChildren()) {
            if (c instanceof Leaf) {
                c.show();
            } else {
                c.show();
                display((Composite) c);
            }
        }
    }
```
测试结果
```
我是根节点
我是树枝节点
我是树叶节点
```
## 优点
* 高层模块调用简单，树形结构中的节点都是Component，局部和整体对调用者没区别
* 节点增加自由，想要增加树枝节点或树叶节点，只要找到父节点就成
## 缺点
对于面向接口编程方面，与依赖倒置是相冲突的
## 扩展
### 真实的组合模式
我们实际开发过程中，最常见的树形结构就是在关系数据库中，定义每个节点并且指定父节点，类似如下

ID|名称|编码|是否树叶节点|pid
---|---|---|---|---
1|系统管理|sys|0|-1
2|用户管理|user|1|1
3|角色管理|role|1|1
4|权限管理|auth|0|1
5|功能菜单权限|menu|1|4
6|数据权限|data|1|4

### 透明的组合模式
组合模式分为透明模式和安全模式，前面讲的都是安全模式，透明模式的代码如下
```java
public abstract class Component {
    private String name;

    public Component(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("我是" + name);
    }

    public abstract void add(Component component);

    public abstract List<Component> getChild();
}
```
定义节点，其中add和getChild是抽象方法
```java
public class Composite extends Component {

    private List<Component> list = new ArrayList<Component>();

    public Composite(String name) {
        super(name);
    }


    public void add(Component component) {
        list.add(component);
    }

    public List<Component> getChild() {
        return list;
    }
}
public class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Deprecated
    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public List<Component> getChild() {
        throw new UnsupportedOperationException();
    }
}
```
分别定义树枝，树叶节点，其中树叶节点add和getChild方法，会抛出异常

单元测试
```
    @Test
    public void testTransparentCompositePattern() {
        Component root = new Composite("根节点");
        root.show();
        Component branch = new Composite("树枝节点");
        Component leaf = new Leaf("树叶节点");
        root.add(branch);
        branch.add(leaf);

        displayTransparent(root);
    }

    private void displayTransparent(Component root) {
        for (Component component : root.getChild()) {
            if (component instanceof Leaf) {
                component.show();
            } else {
                component.show();
                displayTransparent(component);
            }
        }
    }
```
测试结果
```
我是根节点
我是树枝节点
我是树叶节点
```
测试代码其实和安全模式大致类似，只是不需要了强制转换

通过透明模式，解决了依赖倒置问题，实现面向接口编程







