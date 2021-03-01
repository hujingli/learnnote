package com.hujingli.algorithm.leetcode;

public class LeetCode53 {

    public static void main(String[] args) {
        LeetCode53 code53 = new LeetCode53();
        System.out.println(code53.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));;
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], (nums[i] + dp[i - 1]));
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
