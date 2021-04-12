package com.hujingli.algorithm.leetcode.zipStr;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(zipStr(str));

    }

    public static String zipStr(String str){
        Map<Character, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
            if (i > 0 && str.charAt(i - 1) != str.charAt(i)) {
                Integer count = map.get(str.charAt(i-1));
                sb.append(str.charAt(i - 1)).append(count == 1 ? "" : count);
                map.remove(str.charAt(i - 1));
            }
        }
        Integer count = map.get(str.charAt(str.length() - 1));
        sb.append(str.charAt(str.length() - 1)).append(count == 1 ? "" : count);

        return sb.toString();
    }

}
