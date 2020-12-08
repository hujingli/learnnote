package com.hujingli.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 3, 2, 1, 4};
        int[] ints = netherlandsFlag(arr, 0, arr.length - 1);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
            System.out.println();
        }

        quickSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 荷兰国旗问题
    private static int[] netherlandsFlag(int[] arr, int L, int R) {

        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int less = L - 1; // < 区域
        int more = R; // > 区域
        int index = L;
        // {3,5,4,3,2,1,4}
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else {
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[]{less + 1, more};
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int L, int R) {
        if (L > R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R); // 随机找一个数作为arr[R]
        int[] ints = netherlandsFlag(arr, L, R); // 找出的相等的区域
        process(arr, L, ints[0] - 1); // 利用相等区域做二分
        process(arr, ints[1] + 1, R);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
