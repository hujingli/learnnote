package com.hujingli.algorithm.leetcode;

public class LeetCode5 {


    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        int max = 0;
        String str = "";
        for (int i = 1; i <= s.length(); i++) {   //babad
            for (int j = 0; j + i - 1 < s.length(); j++) {

                boolean b = s.charAt(j) == s.charAt(j + i - 1);
                dp[j][j + i - 1] = j + i - 2 >= j + 1 ? dp[j + 1][j + i - 2] && b : b;
                if (dp[j][j + i - 1]) {
                    // ÊÇ»ØÎÄ
                    if (i > max) {
                        max = i;
                        str = s.substring(j, j + i);
                    }
                }
            }
        }
        return str;
    }

}
