package com.hujingli.algorithm.leetcode;

import java.util.*;

public class LeetCode179 {

    public static void main(String[] args) {
        LeetCode179 code179 = new LeetCode179();
        System.out.println(code179.largestNumber(new int[]{0,0}));;
    }

    public String largestNumber(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String stri = nums[i] + String.valueOf(nums[j]);
                String strj = nums[j] + String.valueOf(nums[i]);
                if (stri.compareTo(strj) < 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (nums[0] == 0) {
            return "0";
        }
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

}
