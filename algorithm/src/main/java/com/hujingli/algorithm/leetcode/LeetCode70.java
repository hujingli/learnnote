package com.hujingli.algorithm.leetcode;

public class LeetCode70 {

    public static void main(String[] args) {
        LeetCode70 code70 = new LeetCode70();
        System.out.println(code70.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
