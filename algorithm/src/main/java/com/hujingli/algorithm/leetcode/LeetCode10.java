package com.hujingli.algorithm.leetcode;

public class LeetCode10 {

    public static void main(String[] args) {
        LeetCode10 code10 = new LeetCode10();
        System.out.println(code10.isMatch("abc", "abc*")); // 换成abc 和 abc 比较 dp[2][3] = dp[2][3-1]
        System.out.println(code10.isMatch("abcc", "abc*")); // 换成abc 和 abc dp[3][3] = dp[3-1][3]
        System.out.println(code10.isMatch("abc", "abcc*")); // 换成 abc和abc dp[2][4] = dp[2][3-2]
        System.out.println(code10.isMatch("abc", "abcd*")); // 换成abc和abc dp[2][4] = dp[2][4-2]
        System.out.println(code10.isMatch("abccc", "abc*"));
        System.out.println(code10.isMatch("aa", "a"));
    }

    public boolean isMatch(String s, String p) {
        int lens = s.length();
        int lenp = p.length();
        boolean[][] dp = new boolean[lens + 1][lenp + 1];

        dp[0][0] = true;

        for (int i = 2; i <= lenp; i++) {
            dp[0][i] = p.charAt(i - 1) == '*' && dp[0][i - 2];
        }


        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lenp; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[lens][lenp];

    }

}
