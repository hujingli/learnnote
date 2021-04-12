package com.hujingli.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode16 {


    public static void main(String[] args) {
        LeetCode16 code16 = new LeetCode16();
        System.out.println(code16.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }

    // -1 2 1 -4             1
    public int threeSumClosest(int[] nums, int target) {

        int searchValue = Integer.MAX_VALUE;
        int returnValue = 0;
        Arrays.sort(nums);
        int a, b, c;
        int lastState = -1; // -1 初始值， 0 是小，1是大
        for (int i = 0; i < nums.length; i++) {
            a = i;
            b = a + 1;
            c = nums.length - 1;
            while (b < c) {
                int sum = nums[a] + nums[b] + nums[c];
                int abs = Math.abs(target - sum);
                if (sum == target) { // 如果等于直接返回0
                    return sum;
                } else if (sum < target) { // 如果小于 则移动b 直到大于或等于停下，记下小于的最接近的作为最小值
//                    if (lastState == -1) {
//                        lastState = 0;
//                    } else if (lastState == 1) {
//                        if (searchValue > abs) {
//                            returnValue = sum;
//                        }
//                        return returnValue;
//                    }
                    if (searchValue > abs) {
                        returnValue = sum;
                        searchValue = abs;
                    }
                    b++;
                    while (b < c && nums[b] == nums[b - 1]) {
                        b++;
                    }
                } else { // 如果大于  则移动c 直到小于或等于停下，记下大于最接近的作为最小值
//                    if (lastState == -1) {
//                        lastState = 1;
//                    } else if (lastState == 0) {
//                        if (searchValue > abs) {
//                            returnValue = sum;
//                        }
//                        return returnValue;
//                    }
                    if (searchValue > abs) {
                        returnValue = sum;
                        searchValue = abs;
                    }
                    c--;
                    while (b < c && nums[c] == nums[c + 1]) {
                        c--;
                    }
                }
            }
        }
        return returnValue;

    }

}
