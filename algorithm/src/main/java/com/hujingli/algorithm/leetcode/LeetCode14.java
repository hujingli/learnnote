package com.hujingli.algorithm.leetcode;

public class LeetCode14 {

    public static void main(String[] args) {
        LeetCode14 code14 = new LeetCode14();
        System.out.println(code14.longestCommonPrefix(new String[]{"flower", "", "flight"}));
        System.out.println(code14.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < len && str1.charAt(index)==str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
