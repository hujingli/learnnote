package com.hujingli.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Sports3dSubject implements Subject {

    /**
     * 主题的消息
     */
    private String msg;

    /**
     * 观察者集合
     */
    public List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        if (observers.contains(observer)){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }

    public void setMsg(String msg){
        this.msg = msg;

        notifyObserver();
    }
}
