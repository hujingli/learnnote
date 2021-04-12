package com.hujingli.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode30 {

    public static void main(String[] args) {
        LeetCode30 code30 = new LeetCode30();
        String[] words = {"word","good","best","good"};
        String[] words1 = {"ab","ba","ba"};
        List<Integer> barfoothefoobarman = code30.findSubstring("wordgoodgoodgoodbestword", words);
        List<Integer> barfoothefoobarman1 = code30.findSubstring("ababaab", words1);

        System.out.println(barfoothefoobarman);
        System.out.println(barfoothefoobarman1);
    }

    public List<Integer> findSubstring(String s, String[] words) {

        int len = words[0].length(); // 单个单词的长度

        List<Integer> result = new ArrayList<>();
        int totalLen = words.length * len; // 总长度
        if (s.length() < totalLen) {
            return result;
        }

        int start = 0;

        while (start + totalLen <= s.length()) {
            String subStr = s.substring(start, start + totalLen);
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                map.put(words[i],map.getOrDefault(words[i], 0) + 1);
            }
            int index = 0;
            while (index < subStr.length()) {
                String substring = subStr.substring(index, index + len);
                if (map.get(substring) != null) {
                    Integer integer = map.get(substring);
                    if (integer == 1) {
                        map.remove(substring);
                    } else {
                        map.put(substring, integer - 1);
                    }
                    index += len;
                }else {
                    break;
                }
            }
            if (map.isEmpty()) {
                result.add(start);
            }
            start++;
        }

        return result;
    }


}
