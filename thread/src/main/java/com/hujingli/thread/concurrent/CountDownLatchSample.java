package com.hujingli.thread.concurrent;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CountDownLatchSample {

//    private static int m = 0;

    private static final AtomicInteger m = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        CountDownLatch countDownLatch = new CountDownLatch(threads.length);

        Object o = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10000; j++) {
                    m.incrementAndGet();
                }
                countDownLatch.countDown();
            });
        }

        Arrays.stream(threads).forEach(Thread::start);

        countDownLatch.await();

        System.out.println(m);
    }

}
