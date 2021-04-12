package com.hujingli.algorithm.leetcode;

import java.util.HashMap;
import java.util.concurrent.SynchronousQueue;

public class LeetCode560 {


    public static void main(String[] args) throws InterruptedException {
        LeetCode560 code560 = new LeetCode560();
        System.out.println(code560.subarraySum(new int[]{3,4,7,2,-3,1,7}, 7));
    }

        // 2 5 3 5
        public int subarraySum(int[] nums, int k) {
            int count = 0, pre = 0;
            HashMap < Integer, Integer > mp = new HashMap< >();
            mp.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                pre += nums[i];
                if (mp.containsKey(pre - k)) {
                    count += mp.get(pre - k);
                }
                mp.put(pre, mp.getOrDefault(pre, 0) + 1);
            }
            return count;
        }


}
