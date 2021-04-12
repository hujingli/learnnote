package com.hujingli.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode22 {

    public static void main(String[] args) {
        LeetCode22 code22 = new LeetCode22();
        System.out.println(code22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        return generateParenthesis(2, 3,"(");
    }

    // 2 3 "("
    public List<String> generateParenthesis(int l,int r, String s) {
        List<String> list = new ArrayList<>();
        if (l == 0) {
            while (r > 0) {
                s += ")";
                r--;
            }
            list.add(s);
            return list;
        }

        if (l < r) { // �����ű��������٣����Լ�������Ҳ���Լ�������
            list.addAll(generateParenthesis(l - 1, r, s + "("));

            list.addAll(generateParenthesis(l, r - 1, s + ")"));

        } else { // ֻ�ܼ�������
            list.addAll(generateParenthesis(l - 1, r, s+"("));
        }
        return list;
    }

}
