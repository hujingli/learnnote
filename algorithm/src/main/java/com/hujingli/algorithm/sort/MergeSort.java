package com.hujingli.algorithm.sort;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {2, 100, 2, 2, 3, 11, 4, 5, 12, 3, 6, 8, 2};
        int[] arr1 = {2, 100, 2, 2, 3, 11, 4, 5, 12, 3, 6, 8, 2};

        process(arr, 0, arr.length - 1);
        process2(arr1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        for (int i : arr1) {
            System.out.print(i);
        }
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];  // 辅助数组，长度为需要归并的两个数组的长度和
        int p1 = L;
        int p2 = mid + 1;
        int i = 0;

        // {1,2,5,6}  {2,3,1,5}
        while (p1 <= mid && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        for (int i1 : help) {
            arr[L++] = i1;
        }

    }

    /**
     * 非递归实现
     */
    private static void process2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // {6,5,4,3,2,1}
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N) { // 当mergeSize和N一样大的时候则排序完成
            int L = 0;
            while (L < N) {
                int mid = L + mergeSize - 1;
                if (mid >= N) { // 没有右组
                    break;
                }
                int R = Math.min(mid + mergeSize, N - 1);
                merge(arr, L, mid, R);
                L = R + 1;
            }
            mergeSize <<= 1; // mergeSize
        }
    }


}
