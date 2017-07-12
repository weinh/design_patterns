# 责任链模式
## 定义
使多个对象都有机会处理请求，从而避免了请求的发送者和接收者之间的耦合关系，将这些对象连成一条链，并沿着这条链传递该请求，直到有对象处理它为止。

我们看下通用代码
```java
public class Level {
    private int level;

    public Level(int level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Level) {
            return this.level == ((Level) obj).level;
        } else {
            return false;
        }
    }
}
public class Request {
    public Level getRequestLevel() {
        Random random = new Random();
        return new Level(random.nextInt() % 3);
    }
}
public class Response {
}
```
这几个类辅助使用，定义了请求类，响应类，处理等级类，下面才是重头戏
```java
public abstract class AbstractHandler {
    private AbstractHandler nextHandler;

    public final Response handlerMessage(Request request) {
        Response response = null;
        if (this.getHandlerLevel().equals(request.getRequestLevel())) {
            response = this.echo(request);
        } else {
            if (this.nextHandler != null) {
                response = this.nextHandler.handlerMessage(request);
            } else {
                System.out.println("请求非法");
            }
        }
        return response;

    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract Response echo(Request request);

    protected abstract Level getHandlerLevel();
}
public class Handler1 extends AbstractHandler {
    protected Response echo(Request request) {
        System.out.println("handler1处理请求");
        return null;
    }

    protected Level getHandlerLevel() {
        return new Level(1);
    }
}
public class Handler2 extends AbstractHandler {
    protected Response echo(Request request) {
        System.out.println("handler2处理请求");
        return null;
    }

    protected Level getHandlerLevel() {
        return new Level(2);
    }
}
```
这个代码看起来应该很熟悉，使用了模板方法模式，首先定义处理抽象类，定义链处理逻辑，如果请求等级相等则处理，否则由下一个节点处理，直到没有节点为止

单元测试
```
    @Test
    public void testChain() {
        Request request = new Request();
        AbstractHandler handler1 = new Handler1();
        AbstractHandler handler2 = new Handler2();

        handler1.setNextHandler(handler2);
        Response response = handler1.handlerMessage(request);
    }
```
测试结果
```
handler2处理请求
```
由于Request定义了一个随机数为请求等级，每次执行结果可能不一样，根据请求等级不一样，那个节点处理的也不一样
## 优点
将请求和处理分开了
## 缺点
* 性能问题
>每次请求需要链表头开始处理，直到找到对应的节点
* 调试不方便
>如果链比较长调试起来很麻烦，这种类似递归的方式给调试增加了难度

一般会设定一个最大链长控制下，避免无意间的性能问题