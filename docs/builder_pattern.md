# 建造者模式（生成器模式）
## 定义
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。

这里我们来看一个稍具体的通用代码，大家都知道番茄和鸡蛋是做菜的食材，如果食材的比例和辅料不一样有些烧的是番茄炒蛋，有一些是西红柿蛋汤，接下来开始我们的烹饪之旅吧

首先烧一道菜和番茄，鸡蛋有关
```java
public abstract class AbstractFood {
    private List<String> steps = new ArrayList<String>();

    protected abstract void addTomatoes();

    protected abstract void addEggs();

    protected abstract void addWater();

    protected abstract void addOil();

    private void addSalt() {
        System.out.println("放入适量的盐");
    }

    private void outPot() {
        System.out.println("出锅");
    }

    public final void show() {
        for (String step : steps) {
            if ("Tomatoes".equals(step)) {
                this.addTomatoes();
            } else if ("Eggs".equals(step)) {
                this.addEggs();
            } else if ("Water".equals(step)) {
                this.addWater();
            } else if ("Oil".equals(step)) {
                this.addOil();
            }
        }
        this.addSalt();
        this.outPot();
    }

    protected final void setSteps(List<String> steps) {
        this.steps = steps;
    }
}
```
具体的菜是，番茄炒蛋和西红柿蛋汤
```java
public class TomatoScrambledEggs extends AbstractFood {
    protected void addTomatoes() {
        System.out.println("加入番茄翻炒一会，炒出汤汁，加入鸡蛋翻炒");
    }

    protected void addEggs() {
        System.out.println("炒个鸡蛋，弄小块，装盘");
    }

    protected void addWater() {
        System.out.println("加水");
    }

    protected void addOil() {
        System.out.println("加入油，加热");
    }
}
public class TomatoAndEggSoup extends AbstractFood {
    protected void addTomatoes() {
        System.out.println("放入西红柿，烧一会");
    }

    protected void addEggs() {
        System.out.println("放入打好的鸡蛋，凝固了再搅拌");
    }

    protected void addWater() {
        System.out.println("加很多水，我们是烧汤的");
    }

    protected void addOil() {
        System.out.println("加油");
    }
}
```
这两个菜交给厨师1和厨师2
```java
public abstract class AbstractChef {
    public abstract void setSteps(List<String> steps);

    public abstract AbstractFood cooking();
}
public class Chef1 extends AbstractChef {
    private TomatoAndEggSoup tomatoAndEggSoup = new TomatoAndEggSoup();

    public void setSteps(List<String> steps) {
        tomatoAndEggSoup.setSteps(steps);
    }

    public AbstractFood cooking() {
        return tomatoAndEggSoup;
    }
}
public class Chef2 extends AbstractChef {
    private TomatoScrambledEggs tomatoScrambledEggs = new TomatoScrambledEggs();

    public void setSteps(List<String> steps) {
        tomatoScrambledEggs.setSteps(steps);
    }

    public AbstractFood cooking() {
        return tomatoScrambledEggs;
    }
}
```
两个厨师在厨房里面干活
```java
public class Kitchen {
    List<String> steps = new ArrayList<String>();
    private Chef1 chef1 = new Chef1();
    private Chef2 chef2 = new Chef2();

    public TomatoAndEggSoup createTomatoAndEggSoup() {
        List<String> steps = new ArrayList<String>();
        steps.add("Water");
        steps.add("Tomatoes");
        steps.add("Eggs");
        chef1.setSteps(steps);
        return (TomatoAndEggSoup) chef1.cooking();
    }

    public TomatoScrambledEggs createTomatoScrambledEggs() {
        List<String> steps = new ArrayList<String>();
        steps.add("Oil");
        steps.add("Eggs");
        steps.add("Tomatoes");
        chef2.setSteps(steps);
        return (TomatoScrambledEggs) chef2.cooking();
    }
}
```
单元测试
```
    @Test
    public void testBuilderPattern() {
        Kitchen kitchen = new Kitchen();
        kitchen.createTomatoAndEggSoup().show();
        kitchen.createTomatoScrambledEggs().show();
    }
```
测试结果
```
加很多水，我们是烧汤的
放入西红柿，烧一会
放入打好的鸡蛋，凝固了再搅拌
放入适量的盐
出锅
加入油，加热
炒个鸡蛋，弄小块，装盘
加入番茄翻炒一会，炒出汤汁，加入鸡蛋翻炒
放入适量的盐
出锅
```
## 优点
* 封装性，客户端不需要指定产品的内部组成的细节
* 建造者独立，扩展容易
* 便于控制细节风险

建造者模式关注零件类型和装配工艺（顺序），这是与工厂方法模式不通的地方
