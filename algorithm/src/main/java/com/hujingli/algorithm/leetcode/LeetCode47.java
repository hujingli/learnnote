package com.hujingli.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode47 {

    List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        LeetCode47 code47 = new LeetCode47();
        System.out.println(code47.permuteUnique(new int[]{1,1,2}));
    }

    // 1 1 2
    public List<List<Integer>> permuteUnique(int[] nums) {
        dfs(nums, 0);
        return result;
    }

    public void dfs(int[] nums, int x) {
        if (x == nums.length - 1) {

            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = x; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            swap(nums, x, i);
            dfs(nums, x + 1);
            swap(nums, x, i);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
