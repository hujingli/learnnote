package com.hujingli.algorithm.leetcode;

public class LeetCode264 {

    public static void main(String[] args) {
        LeetCode264 code264 = new LeetCode264();
        System.out.println(code264.nthUglyNumber(10));
    }


    public int nthUglyNumber(int n) {

        int[] nums = new int[1690];
        nums[0] = 1;
        int ugly;
        int i2 = 0, i3 = 0,i5 = 0;
        for (int i = 1; i < 1690; i++) {
             ugly = Math.min(Math.min(nums[i2] * 2, nums[i3] * 3), nums[i5] * 4);
            nums[i] = ugly;

            if (ugly == nums[i2] * 2) i2++;
            if (ugly == nums[i3] * 3) i3++;
            if (ugly == nums[i5] * 4) i5++;
        }
        return nums[n - 1];

    }

}
