package com.hujingli.algorithm.sort;

/**
 * 堆排序 大顶堆
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 5, 3, 2, 6, 8};
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        for (int i = 0; i < heapSize; i++) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 上浮  刚进入数组的数
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 下沉
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1; // 左孩子
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
