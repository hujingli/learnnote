### 观察者模式

---

##### 观察者模式的模型

 - 抽象主题
 - 抽象观察者
 - 具体主题
 - 具体观察者
 
![github](http://154.8.226.45/learnnote/%E8%A7%82%E5%AF%9F%E8%80%85%E6%A8%A1%E5%BC%8F.png "github") 

如上类图

包 `com.hujingli.design`中代码设计便是参照此模型进行设计

一、以3d福利彩票为例子

1、主题为体彩3d 

2、观察者是购买彩票的人

3、现在有3个人  A B C分别去购买彩票   彩票开奖时需要通知他们 
此时他们需要注册自己到彩票主题上  当彩票主题开奖时便会给注册在他上面的
观察者发送彩票开奖信息。

（具体实现可以参照代码实现）


二、为什么要使用观察者模式 
   
以一个例子来表述
传统的我们进行购买车票这样一个动作可能会有（
1、日志记录
2、记录流水
3、。。。
）等功能。
传统的方式就是
```java
 buyTickets(); // 1
 saveLog();//2
 saveSeq();//3

```

如果此时我们需要在买票后增加新的步骤还是需要在购票的代码流程下去
增加这个新的步骤。

如果使用观察者模式呢？

1、有一个购票对象作为一个被观察者拥有几个方法

```java
addObserver(ObServer ob); //注册观察者
deleteObserver(ObServer ob); // 删除观察者
notifyObserver(); // 提醒观察者
buy(); // 购票动作  购买完票之后调用提醒观察者方法提醒所有观察者干自己的事情
```

```java
Tickets implements Subject{
    // 存放观察者的集合
    List<Observer> obs = new ArrayList<>();

    addObserver(ObServer ob){
        obs.add(ob);
    }
    deleteObserver(ObServer ob){
        obs.remove(ob);
    }
    notifyObserver(){
        for // 遍历每一个ob
        ob.update();
    }   
    buy(){
        // 具体的购票逻辑 
    }
}

```

2、有一个记录日志观察者  一个新增流水观察者  
```java
update();

// 每个观察者都具有这个update()方法  当被观察者调用notifyObserver
// 会调用已经注册的观察者的update()方法进行自己的业务操作。
```

```java
LogObserver implements Observer{
    update(){
        // 记录日志
    }
}
```

```java
SeqObserver implements Observer{
    update(){
        // 记录流水 
    }
}
```

三、总结
观察者模式定义的是一对多的依赖关系，一个被观察者可以拥有多个观察者，并且通过接口对观察者与被观察者进行逻辑解耦，降低二者的直接耦合。