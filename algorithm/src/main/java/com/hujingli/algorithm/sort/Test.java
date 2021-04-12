package com.hujingli.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class Test {

    List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
       int x=  0x14141414;

       // 0000 0000 0000 0000
        System.out.println(x);

    }

    public static long trailingZeros(long n) {
        long count = 0;
        long pwr = 25;
        for (long temp = 5; temp <= n; temp += 5) {
            count++;
            pwr = 25;
            while (temp % pwr == 0) {
                count++;
                pwr *= 5;
            }
        }
        return count;
    }

    public List<List<String>> get(String[] strs) {
        get(strs, new ArrayList<>(), 0);
        return result;
    }

    // a b c
    public void get(String[] strs, List<String> list, int x) {

        if (x == strs.length) {
            if (!list.isEmpty()) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        // 选取
        list.add(strs[x]);
        get(strs, list, x + 1);

        // 不选
        list.remove(strs[x]);
        get(strs, list, x + 1);

    }


}
