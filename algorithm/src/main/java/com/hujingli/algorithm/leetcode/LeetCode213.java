package com.hujingli.algorithm.leetcode;

public class LeetCode213 {

    public static void main(String[] args) {
        LeetCode213 code213 = new LeetCode213();
        System.out.println(code213.rob(new int[]{2,3,2}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));

    }

    public int rob(int[] nums, int start, int end) {

        int max = 0, pre = 0;
        for (int i = start; i < end; i++) {
            int temp = max;
            max = Math.max(pre + nums[start], temp);
            pre = temp;
        }
        return max;
    }

}
