package com.hujingli.design.observer;

/**
 * 观察者模式
 */
public class Main {

    public static void main(String[] args) {

        Subject subject = new Sports3dSubject();

        Observer observer1 = new ObserverPerson("A", subject);
        Observer observer2 = new ObserverPerson("B", subject);
        Observer observer3 = new ObserverPerson("C", subject);

        subject.setMsg("这一期的彩票中奖号码为："+ "01,03,04,06,02,07");

    }

}
