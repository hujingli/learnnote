package com.hujingli.algorithm.leetcode;

public class LeetCode29 {

    public static void main(String[] args) {
        LeetCode29 code29 = new LeetCode29();
        System.out.println(code29.divide(2147483647, 3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isFu = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) divisor = -divisor;

        int result = 0;
        while (dividend <= divisor) {
            int tempDivisor = divisor;
            int tempResult = 1;
            while (dividend <= (tempDivisor << 1)) {
                if(tempDivisor <= (Integer.MIN_VALUE >> 1))break;
                tempResult = tempResult << 1;
                tempDivisor = tempDivisor << 1;
            }
            dividend -= tempDivisor;
            result += tempResult;
        }
        if (isFu) {
            result = -result;
        }
        return result;

    }


}
