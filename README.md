# 6大设计原则
## 单一职责原则
一个接口，一个类，一个方法只干一个事情

## 里氏替换原则
详细说明如下链接

[里氏替换原则](https://weinh.github.io/design_patterns/docs/lsp)
## 倒置依赖原则
### 定义
* 高层模块不应该依赖底层模块，两则都应该依赖其抽象

* 抽象不应该依赖细节

* 细节应该依赖抽象

通俗来讲就是
>* 模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，其依赖关系是通过接口或抽象类产生的
>* 接口和抽象类不依赖于实现类
>* 实现类依赖接口或抽象类

面向接口编程是OOP的精髓之一

### 好处
依赖倒置原则可以减少类间的耦合性，提高系统稳定性，降低并行开发引起的风险，提高代码的可读性和可维护性

依赖的三种方式
1. 构造函数注入
2. setter依赖注入
3. 接口注入

## 接口隔离原则
### 定义
客户端不应该依赖它不需要的接口

类间的依赖关系应该建立在最小的接口上

## 迪米特法则（最少知识原则）
### 定义
一个对象应该对其他对象有最少的了解，一个类应该对自己需要耦合或调用的类知道的最少

## 开闭原则
### 定义
对扩展开发，对修改关闭

如何做到开闭原则呢，上面提到的五个原则具有实际的指导意义
* 抽象约束
* 元数据控制模块行为
* 制定项目章程
* 封装变化
>将相同的变化封装到同一个接口或抽象类中，将不同的变化封装到不同的接口或抽象类中，不应该有两个不同的变化出现在同一个接口或抽象类中

# 23种设计模式
1. [单例模式](https://weinh.github.io/design_patterns/docs/singleton_pattern)
2. [工厂方法模式](https://weinh.github.io/design_patterns/docs/factory_method_pattern)
3. [抽象工厂模式](https://weinh.github.io/design_patterns/docs/abstract_factory_pattern)
4. [模板方法模式](https://weinh.github.io/design_patterns/docs/template_method_pattern)
5. [建造者模式（生成器模式）](https://weinh.github.io/design_patterns/docs/builder_pattern)
6. [代理模式](https://weinh.github.io/design_patterns/docs/proxy_pattern)
7. [原型模式](https://weinh.github.io/design_patterns/docs/prototype_pattern)
8. [中介者模式（调停者模式）](https://weinh.github.io/design_patterns/docs/mediator_pattern)
9. [命令模式](https://weinh.github.io/design_patterns/docs/command_pattern)
10. [责任链模式](https://weinh.github.io/design_patterns/docs/chain_responsibility_pattern)
11. [装饰模式](https://weinh.github.io/design_patterns/docs/decorator_pattern)
12. [策略模式（政策模式）](https://weinh.github.io/design_patterns/docs/strategy_pattern)
13. [适配器模式（变压器模式，包装模式）](https://weinh.github.io/design_patterns/docs/adapter_pattern)
14. [迭代器模式](https://weinh.github.io/design_patterns/docs/iterator_pattern)
15. [组合模式（合成模式，部分-整体模式）](https://weinh.github.io/design_patterns/docs/composite_pattern)
16. [观察者模式（发布订阅模式）](https://weinh.github.io/design_patterns/docs/observer_pattern)
17. [门面模式](https://weinh.github.io/design_patterns/docs/facade_pattern)
18. [备忘录模式](https://weinh.github.io/design_patterns/docs/memento_pattern)
19. [访问者模式](https://weinh.github.io/design_patterns/docs/visitor_pattern)
20. [状态模式](https://weinh.github.io/design_patterns/docs/status_pattern)
21. [解释器模式](https://weinh.github.io/design_patterns/docs/interpreter_pattern)
22. [享元模式](https://weinh.github.io/design_patterns/docs/flyweight_pattern)