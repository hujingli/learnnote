package com.hujingli.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class LeetCode12 {


    public static void main(String[] args) {
        LeetCode12 code12 = new LeetCode12();
        System.out.println(code12.intToRoman(3));
        System.out.println(code12.intToRoman(4));
        System.out.println(code12.intToRoman(9));
        System.out.println(code12.intToRoman(58));
        System.out.println(code12.intToRoman(1994));
        System.out.println(code12.intToRoman(2005));

    }

    public String intToRoman(int num) {

        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        StringBuilder result = new StringBuilder();
        for (int i = value.length - 1; i >= 0; i--) {
            if (num < value[i]) {
                continue;
            }
            if (num == value[i]) {
                result.append(roman[i]);
            } else {
                int temp = num / value[i];
                for (int j = 0; j < temp; j++) {
                    result.append(roman[i]);
                }
            }
            num = num % value[i];
        }

        return result.toString();

    }
}
