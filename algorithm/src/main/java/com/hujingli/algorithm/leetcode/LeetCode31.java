package com.hujingli.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode31 {

    // 4,2,0,2,3,2,0
    // 4,2,0,3,0,2,2[2,2,7,5,4,3,2,2,1]
    // j  i
    public static void main(String[] args) {
        LeetCode31 code31 = new LeetCode31();
        int[] nums = {4, 2, 0, 2, 3, 2, 0};
        code31.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public void nextPermutation1(int[] nums) {

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        Arrays.sort(nums, i + 1, nums.length - 1);

    }

    public void nextPermutation(int[] nums) {
        boolean flag = false;

        flag = nextPermutation(nums, 0, nums.length - 1, false);

        if (!flag) {
            Arrays.sort(nums);
        }

    }

    public boolean nextPermutation(int[] nums, int start, int end, boolean flag) {
        if (start >= end) {
            return flag;
        }
        for (int i = end; i >= start; i--) {
            int num = nums[i];
            for (int j = i - 1; j >= start; j--) {
                if (num > nums[j]) {
                    if (i - j > 2) {
                        flag = nextPermutation(nums, j + 1, i - 1, false);
                        if (!flag) {
                            nums[i] = nums[j];
                            nums[j] = num;
                            Arrays.sort(nums, j + 1, nums.length);
                        }
                    } else {
                        nums[i] = nums[j];
                        nums[j] = num;
                        Arrays.sort(nums, j + 1, nums.length);
                    }
                    return true;

                }

            }
        }
        return flag;

    }

}
