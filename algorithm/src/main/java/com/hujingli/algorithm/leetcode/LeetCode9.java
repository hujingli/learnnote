package com.hujingli.algorithm.leetcode;

public class LeetCode9 {
    public static void main(String[] args) {
        LeetCode9 code9 = new LeetCode9();
        System.out.println(code9.isPalindrome(12121));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result == x || x == result / 10;
    }


}
