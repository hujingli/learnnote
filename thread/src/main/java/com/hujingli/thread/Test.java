package com.hujingli.thread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.SynchronousQueue;

/**
 * @author exphuhong
 * @date 2021/4/1 0001
 */
public class Test implements Cloneable {

    public static volatile Integer count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {

            new Thread(() -> {
                synchronized (o) {
                    count++;
                    latch.countDown();
                }
            }).start();

        }
        latch.await();
        System.out.println(count);


    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Test test = new Test();
        return super.clone();
    }
}
