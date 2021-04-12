package com.hujingli.thread.cusvolatile;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VolatileTest {

    static  boolean  shutdownRequest;

    static ThreadLocal<Integer> threadLocal  = new ThreadLocal<>();
    static ReadWriteLock lock = new ReentrantReadWriteLock();


    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[5];

        lock.readLock().lock();

        CountDownLatch countDownLatch = new CountDownLatch(threads.length);

        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                doWork();

                countDownLatch.countDown();
            });
        }

        Arrays.stream(threads).forEach(Thread::start);

        countDownLatch.await();

    }

    public static void shutDown(){
        shutdownRequest = true;
    }

    public static void doWork(){
        while (!shutdownRequest) {
            System.out.println(Thread.currentThread().getName() + "工作中。。。");
            Integer integer = threadLocal.get();
            integer = Optional.ofNullable(integer).orElse(0);
            if (integer == 3){
                shutDown();
            }
            threadLocal.set(integer + 1);

        }
    }

}
