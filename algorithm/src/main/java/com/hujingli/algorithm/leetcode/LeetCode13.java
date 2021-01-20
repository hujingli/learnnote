package com.hujingli.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode13 {

    public static void main(String[] args) {
        LeetCode13 code13 = new LeetCode13();
        System.out.println(code13.romanToInt("III"));
        System.out.println(code13.romanToInt("IV"));
        System.out.println(code13.romanToInt("IX"));
        System.out.println(code13.romanToInt("LVIII"));
        System.out.println(code13.romanToInt("MCMXCIV"));
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            String a = String.valueOf(s.charAt(i));
            if (i - 1 >= 0) {
                String b = String.valueOf(s.charAt(i - 1));
                if (map.get(a) <= map.get(b)) {
                    result += map.get(a);
                } else {
                    result += map.get(a) - map.get(b);
                    i--;
                }
            } else {
                result += map.get(a);
            }

        }
        return result;

    }

}
