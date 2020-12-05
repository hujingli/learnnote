package com.hujingli.algorithm.sort;

public class InsertSort {


    public static void main(String[] args) {

        //  2 4 1 3 5 6
        //  1 2 3 4 5 6

        int[] arr = {2, 4, 1, 3, 5, 6, 1, 2, 3, 10, 2, 6, 4};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
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
