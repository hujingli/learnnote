package com.hujingli.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode75 {

    public static void main(String[] args) {

        LeetCode75 code75 = new LeetCode75();
        int[] nums = {2, 0, 2, 1, 1, 0};
        code75.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        quickSort(nums, 0 , nums.length-1);
    }


    private static void quickSort(int[] arr, int l, int r) {

        if (l > r) {
            return;
        }
        int L = arr[l];
        int i = l;
        int j = r;
        while (i < j) {

            // 从右往左找比L小的
            while (i < j && arr[j] >= L) {
                j--;
            }
            while (i < j && arr[i] <= L) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }

        }
        arr[l] = arr[i];
        arr[i] = L;
        quickSort(arr, l, i-1);
        quickSort(arr, i+1, r);

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
