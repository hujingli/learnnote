package com.hujingli.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode6 {

    public static void main(String[] args) {
        LeetCode6 code6 = new LeetCode6();
        System.out.println(code6.convert("ABCD", 3));

    }

    public String convert(String s, int numRows) {

        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            list.add(sb);
        }

        int rowNum = 0;

        for (int i = 0; i < s.length(); i++) {
            list.get(rowNum).append(s.charAt(i));
            if (rowNum + 1 == numRows && i < s.length() - 1) {
                rowNum--;
                while (rowNum >= 0) {
                    i++;
                    list.get(rowNum).append(s.charAt(i));
                    if (i < s.length() - 1) {
                        rowNum--;
                    } else {
                        break;
                    }
                }
                rowNum++;
            }
            rowNum++;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : list) {
            result.append(stringBuilder.toString());
        }
        return result.toString();
    }

}
