package com.hujingli.algorithm.leetcode;

public class LeetCode11 {

    public static void main(String[] args) {
        LeetCode11 code11 = new LeetCode11();
        System.out.println(code11.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

}
