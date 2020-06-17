package com.hujingli.design.observer;

public class ObserverPerson implements Observer{

    private String name;

    public ObserverPerson(String name, Subject subject) {
        this.name = name;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println(name + msg);
    }
}
