package com.hujingli.thread;

import java.io.File;

public class ThreadLocalTest {

    public static  ThreadLocal<String> local = new ThreadLocal<String>();


    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                String name = local.get();
//                if (name == null){
//                    name = Thread.currentThread().getName()+"i";
//                    local.set(name);
//                    System.out.println("设置name");
//                }
//                System.out.println(name);
//            }).start();
//        }

    }

}
