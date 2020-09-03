package com.hujingli.design.singleton;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Description 懒汉式单例  (存在线程安全的问题)
 * @since
 */
public class Singleton02 {

    private static Singleton02 singleton02 ;

    private Singleton02() {
    }

    public static Singleton02 getInstance() {
        if (singleton02 == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            singleton02 = new Singleton02();
        }
        return singleton02;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(Singleton02.getInstance().hashCode())).start();
        }
    }

}
