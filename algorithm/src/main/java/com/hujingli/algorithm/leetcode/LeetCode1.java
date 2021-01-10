package com.hujingli.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    public static void main(String[] args) {
        LeetCode1 leetCode1 = new LeetCode1();
        leetCode1.twoSum(new int[]{3, 2, 4}, 6);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numsMap.containsKey(target - nums[i])) {
                return new int[]{numsMap.get(target - nums[i]), i};
            }
            numsMap.put(nums[i], i);
        }
        return new int[0];
    }

}
