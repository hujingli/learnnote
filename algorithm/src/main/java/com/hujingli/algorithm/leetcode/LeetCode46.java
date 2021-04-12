package com.hujingli.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode46 {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        LeetCode46 code46 = new LeetCode46();
        System.out.println(code46.permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {

        permute(nums, 0);
        return result;
    }

    public void permute(int[] nums, int x) {

        if (x == nums.length - 1) {

            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        for (int i = x; i < nums.length; i++) {
            swap(nums, x, i);
            permute(nums, x + 1);
            swap(nums, x, i);
        }

    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
