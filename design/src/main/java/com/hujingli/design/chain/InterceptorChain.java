package com.hujingli.design.chain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author <a href="exphuhong@163.com">胡红</a>
 * @Date 2020 年 09 月 06 日
 * @Description
 * @since
 */
public class InterceptorChain implements Interceptor{

    List<Interceptor> interceptors = new LinkedList<>();

    @Override
    public boolean interceptor() {

        for (int i = 0; i < interceptors.size(); i++) {
            if (interceptors.get(i).interceptor()) {
                return true;
            }
        }


        return false;
    }

    public void add(Interceptor interceptor) {
        this.interceptors.add(interceptor);
    }
}
