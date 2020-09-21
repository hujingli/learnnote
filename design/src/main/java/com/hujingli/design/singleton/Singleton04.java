package com.hujingli.design.singleton;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Description dcl双检查模式
 * @since
 */
public class Singleton04 {
    private static volatile Singleton04 singleton04 = null;

    private Singleton04() {

    }

    public static Singleton04 getInstance() {
        if (singleton04 == null) {
            synchronized (Singleton04.class) {
                if (singleton04 == null) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    singleton04 = new Singleton04();
                }
            }
        }
        return singleton04;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton04.getInstance().hashCode())).start();
        }
    }
}
