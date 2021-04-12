package com.hujingli.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode39 {

    public static void main(String[] args) {
        LeetCode39 code39 = new LeetCode39();
        System.out.println(code39.combinationSum(new int[]{2, 3, 5}, 8));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int x) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = x; i < candidates.length; i++) {
            int num = target - candidates[i];
            if (num > 0) {
                List<List<Integer>> lists = combinationSum(candidates, num, i);
                for (List<Integer> list : lists) {
                    list.add(candidates[i]);
                    result.add(list);
                }
            } else if (num == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                result.add(list);
            }
        }
        return result;

    }


}
