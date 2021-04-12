package com.hujingli.algorithm.leetcode;

import java.util.*;

public class LeetCode40 {

    public static void main(String[] args) {

        LeetCode40 code40 = new LeetCode40();
        System.out.println(code40.combinationSum(new int[]{10,1,2,7,6,1,5}, 8));

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int x) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = x; i < candidates.length; i++) {
            if (set.contains(candidates[i])) {
                continue;
            }
            set.add(candidates[i]);
            int num = target - candidates[i];
            if (num > 0) {
                List<List<Integer>> lists = combinationSum(candidates, num, i+1);
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
