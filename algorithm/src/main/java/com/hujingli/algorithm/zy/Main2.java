package com.hujingli.algorithm.zy;

import java.util.*;

public class Main2 {

    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        count(arr, 24, 0);
        System.out.println(count);

    }


    // 1 1 2 22 23
    public static void count(int[] arr, int target, int start) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            count++;
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            count(arr, target - arr[i], i + 1);
        }
    }

}
