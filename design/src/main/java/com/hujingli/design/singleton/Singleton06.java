package com.hujingli.design.singleton;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Description 枚举方式
 * @since
 */
public enum Singleton06 {

    INSTANCE
    ;

    public String method(){
        return "测试枚举单例";
    }

    public static void main(String[] args) {
        System.out.println(Singleton06.INSTANCE.method());
    }

}
