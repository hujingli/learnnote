package com.hujingli.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadLocalTest {

    private static volatile boolean isStarted = false;
    final Object lock = new Object();
    Lock lck = new ReentrantLock();
    Thread A = new Thread(() -> {
        isStarted = true;
        synchronized (lock) {
            try {
                char temp = 'A';
                for (int i = 0; i < 26; i++) {
                    System.out.print(temp++);
                    lock.notify();
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.notify();
            }
        }

    }
    );
    Thread B = new Thread(() -> {
        synchronized (lock) {
            try {
                if (!isStarted) {
                    lock.wait();
                }
                for (int i = 0; i < 26; i++) {
                    System.out.print(i + 1);
                    lock.notify();
                    lock.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.notify();
            }
        }


    }
    );

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        t.B.start();
        t.A.start();
    }
}
