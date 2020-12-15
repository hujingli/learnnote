package com.hujingli.algorithm.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 堆排序 找出最小的k个数
 */
public class JZ29 {

    public static void main(String[] args) {
        JZ29 jz29 = new JZ29();
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> list = jz29.GetLeastNumbers_Solution(arr, 4);
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k > input.length || k <= 0) {
            return new ArrayList<>();
        }

        int heapSize = input.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = input.length - 1; i >= 0; i--) {
            heapify(input, i, heapSize);
        }
        swap(input, 0, --heapSize);
        arr.add(input[heapSize]);
        for (int i = 0; i < k - 1; i++) {
            heapify(input, 0, heapSize);
            swap(input, 0, --heapSize);
            arr.add(input[heapSize]);
        }
        return arr;
    }

    private void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int smallest = left + 1 < heapSize && arr[left + 1] < arr[left] ? left + 1 : left; // 看选左孩子还是右孩子
            smallest = arr[smallest] < arr[index] ? smallest : index; // 判断最小的孩子和自己哪个大
            if (smallest == index) {
                break;
            }
            swap(arr, index, smallest);
            index = smallest;
            left = index * 2 + 1;

        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        if (k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> arr = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }
        for (int i = 0; i < k; i++) {
            arr.add(queue.poll());
        }

        return arr;
    }

}
