package com.hujingli.algorithm.zy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.locks.LockSupport;

public class  Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        System.out.println(getNewString(line));

    }

    public static String getNewString(String str) {


        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.merge(str.charAt(i), 1, Integer::sum);
        }

        StringBuilder sb = new StringBuilder();
        map.forEach((k, v)->{
            sb.append(k).append(v);
        });

        return sb.toString();

    }

}
