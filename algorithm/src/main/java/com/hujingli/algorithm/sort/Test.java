package com.hujingli.algorithm.sort;

public class Test {


    public static void main(String[] args) {
        System.out.println(trailingZeros(100));
    }

    public static  long trailingZeros(long n) {
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

}
