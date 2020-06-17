package com.hujingli.design.observer;

public interface Subject {

    /**
     * 注册观察者
     * @param observer
     */
    void registerObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    void deleteObserver(Observer observer);

    /**
     * 提醒观察者
     */
    void notifyObserver();

    /**
     * 主题设置消息
     * @param msg
     */
    void setMsg(String msg);

}
