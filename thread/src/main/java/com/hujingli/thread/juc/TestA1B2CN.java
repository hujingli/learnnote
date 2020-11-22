package com.hujingli.thread.juc;

import java.util.concurrent.locks.LockSupport;

public class TestA1B2CN {

    public static Thread t1 , t2;

    public static void main(String[] args) {

        t1 = new Thread(() -> {
            char s = 'a';
            for (int i = 0; i < 26; i++) {
                System.out.print(s++);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
            LockSupport.unpark(t2);
        });

        t2 = new Thread(() -> {
            int s = 1;
            LockSupport.park();
            for (int i = 0; i < 26; i++) {
                System.out.print(s++);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
            LockSupport.unpark(t1);

        });

        t1.start();
        t2.start();

    }

}
