package com.hujingli.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode3 {

    public static void main(String[] args) {
        LeetCode3 code3 = new LeetCode3();
        System.out.println(code3.lengthOfLongestSubstring("dvdf"));
    }

    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int max = 0;
        int start = 0;
        int end = -1;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                start = Math.max(start, map.get(chars[i]) + 1);
            }
            end++;
            max = Math.max(max, end - start + 1);
            map.put(chars[i], i);
        }
        return max;
    }

}
