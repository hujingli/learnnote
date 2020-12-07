package com.hujingli.algorithm.offer;

/**
 * 调整数组顺序，奇数位于偶数前面
 */
public class JZ13 {


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 1, 3, 4, 9};
        JZ13 jz13 = new JZ13();
        jz13.reOrderArray(arr);
    }

    // {1,3,4,6,1,3,4,9}
    public void reOrderArray(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (array[j] % 2 != 0 && array[j-1] % 2 == 0) {
                    swap(array, j, j-1);
                }
            }
        }

        for (int i : array) {
            System.out.print(i);
        }

    }
    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
