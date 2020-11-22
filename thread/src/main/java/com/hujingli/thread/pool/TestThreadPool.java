package com.hujingli.thread.pool;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                new MyThreadFactory()
//                new ThreadPoolExecutor.AbortPolicy() //拒绝
//                new ThreadPoolExecutor.CallerRunsPolicy() // main 线程来执行
//                new ThreadPoolExecutor.DiscardOldestPolicy() // 扔掉等待最久的
//                new ThreadPoolExecutor.DiscardPolicy()
        );

        for (int i = 0; i < 9; i++) {
            poolExecutor.execute(new Task(i));
        }

        System.out.println(poolExecutor.getQueue());

//        poolExecutor.execute(new Task(100));

        System.out.println(poolExecutor.getQueue());

        poolExecutor.shutdown();

    }
    static class Task implements Runnable {
        private int i;

        public Task(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Task " + i);
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            return "Task{" +
                    "i=" + i +
                    '}';
        }
    }

}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread();
        thread.setName("测试线程池"+Thread.currentThread().getId());
        return new Thread(r);
    }
}
