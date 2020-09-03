package com.hujingli.design.singleton;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Description 静态内部类方式
 * @since
 */
public class Singleton05 {

    private Singleton05(){}

    public static class Singleton05Holder{
        private static Singleton05 INSTANCE = new Singleton05();
    }

    public static Singleton05 getInstance() {
        return Singleton05Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Singleton05.getInstance().hashCode())).start();
        }
    }


}
