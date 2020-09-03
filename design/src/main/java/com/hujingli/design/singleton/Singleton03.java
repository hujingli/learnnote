package com.hujingli.design.singleton;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Description 懒汉式单例  (加synchronized关键字解决线程安全的问题， 有效率问题)
 * @since
 */
public class Singleton03 {

    private static Singleton03 singleton03 = null;

    private Singleton03() {
    }

    public synchronized static Singleton03 getInstance() {
        if (singleton03 == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton03 = new Singleton03();
        }
        return singleton03;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton03.getInstance().hashCode())).start();
        }
    }


}
