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

        int result = 0;
        int i = s.length() -1 ;
        for (; i > 0; i--) {
            if (getValue(s.charAt(i))<= getValue(s.charAt(i-1))) {
                result += getValue(s.charAt(i));
            } else {
                result += getValue(s.charAt(i)) - getValue(s.charAt(i-1));
                i--;
            }
        }
        if (i == 0) {
            result += getValue(s.charAt(i));
        }
        return result;

    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
