package com.hujingli.algorithm.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5, 6, 1, 2, 3, 10, 2, 6, 4};

        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i ; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }


        for (int i : arr) {
            System.out.print(i + " ");
        }


    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
