package com.hujingli.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {

    static final Map<Character, Object> map = new HashMap<Character, Object>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};


    public static void main(String[] args) {
        LeetCode17 code17 = new LeetCode17();
        System.out.println(code17.letterCombinations("2"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        letterCombinations(result, digits, 0, "");
        return result;
    }

    public void letterCombinations(List<String> result, String digits, int index, String s) {

        if (digits.length()  == index) {
            result.add(s);
            return;
        }

        char c = digits.charAt(index);
        String o = (String) map.get(c);
        for (int i = 0; i < o.length(); i++) {
            String str = s + o.charAt(i);
            letterCombinations(result, digits, index + 1, str);
        }

    }

}
