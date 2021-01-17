package com.hujingli.algorithm.leetcode;

public class LeetCode7 {

    public static void main(String[] args) {
        LeetCode7 code7 = new LeetCode7();
//        System.out.println(code7.reverse(1463847412));
        System.out.println(-123 % 10);
    }

    public int reverse(int x) {
        int result = 0;
        boolean isFu = false;
        if (x < 0) {
            x = -x;
            isFu = true;
        }
        while (x > 0) {
            int pop = x % 10;
            if (result <= (Integer.MAX_VALUE / 10)) {
                result = result * 10 + pop;
            } else {
                return 0;
            }
            x = x / 10;
        }
        if (isFu) {
            result = -result;
        }
        return result;
    }

}
