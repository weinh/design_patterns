# 解释器模式
# 定义
给定一门语言，定义它的文法的一种表示，并定义一个解释器，该解释器使用该表示来解释语言中的句子。

我们来看下通过程序如何解释数学公式的表达意义
```java
public abstract class Expression {
    public abstract int interpreter(Map<String, Integer> context);
}
public abstract class NonTerminalExpression extends Expression {
    Expression left;
    Expression right;

    public NonTerminalExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
public class TerminalExpression extends Expression {
    private String var;

    public TerminalExpression(String var) {
        this.var = var;
    }

    public int interpreter(Map<String, Integer> context) {
        System.out.println("这里计算：" + var + "=" + context.get(var));
        return context.get(var);
    }

    @Override
    public String toString() {
        return var;
    }
}
```
定义一个抽象表达式，文法的定义包含终结表达式和非终结表达式，终结表达式只有一种，不管可以有很多实例，比如数字1，2，3

非终结表达式可以有很多种，比如+，-，*，/等，不同的非终结表达式对应一个实现类
```java
public class SubExpression extends NonTerminalExpression {

    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(Map<String, Integer> context) {
        System.out.println("这里计算：" + left + "-" + right);
        return super.left.interpreter(context) - super.right.interpreter(context);
    }

    @Override
    public String toString() {
        return left + "-" + right;
    }
}
public class AddExpression extends NonTerminalExpression {
    public AddExpression(Expression left, Expression right) {
        super(left, right);
    }

    public int interpreter(Map<String, Integer> context) {
        System.out.println("这里计算：" + left + "+" + right);
        return super.left.interpreter(context) + super.right.interpreter(context);
    }

    @Override
    public String toString() {
        return left + "+" + right;
    }
}
```
单元测试
```
public class TestInterpreter {
    @Test
    public void testInterpreter() {
        Calc calc = new Calc("a+b-c+d-e");
        Map<String, Integer> vars = new HashMap<String, Integer>();
        vars.put("a", 10);
        vars.put("b", 20);
        vars.put("c", 5);
        vars.put("d", 1);
        vars.put("e", 20);
        System.out.println(calc.calc(vars));
    }
}
```
测试结果
```
这里计算：a+b-c+d-e
这里计算：a+b-c+d
这里计算：a+b-c
这里计算：a+b
这里计算：a=10
这里计算：b=20
这里计算：c=5
这里计算：d=1
这里计算：e=20
6
```
# 优点
解释器是一个简单的语法分析工具，它最著名的优点就是扩展性，修改语法只要修改对应的非终结表达式，扩展语法只要新增非终结表达式对应的子类

# 缺点
* 解释器模式将引起类的膨胀
* 解释器模式采用递归的方式调用性能比较差，排查问题比较困难

# 使用场景
* 重复发生的问题可以使用解释器模式
* 一个简单的语法需要解释的场景
