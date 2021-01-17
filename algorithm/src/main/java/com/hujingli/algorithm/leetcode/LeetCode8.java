package com.hujingli.algorithm.leetcode;

public class LeetCode8 {

    public static void main(String[] args) {
        LeetCode8 code8 = new LeetCode8();
        System.out.println(code8.myAtoi("42"));
        ;
        System.out.println(code8.myAtoi("-42"));
        System.out.println(code8.myAtoi("words and 987"));
        System.out.println(code8.myAtoi("4193 with words"));
        System.out.println(code8.myAtoi("-91283472332"));
        System.out.println(code8.myAtoi("+1"));
        System.out.println(code8.myAtoi("2147483648"));
        System.out.println(code8.myAtoi("2147483646"));
    }

    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        char c = s.charAt(0);
        boolean isFu = false;
        if ('-' == c) {
            if (s.length() > 1) {
                if ((s.charAt(1) < '0' || s.charAt(1) > '9')) {
                    return 0;
                } else {
                    isFu = true;
                }
            } else {
                return 0;
            }
        }
        int index = isFu ? 1 : 0;
        int result = 0;
        index = c == '+' ? 1 : index;
        for (; index < s.length(); index++) {
            if ((s.charAt(index) < '0' || s.charAt(index) > '9') ) {
                break;
            }
            if (result <= Integer.MAX_VALUE / 10.0 - (s.charAt(index) - '0')/10.0) {
                result = result * 10 + (s.charAt(index) - '0');
            } else {
                return isFu ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        return isFu ? -result : result;

    }

}
