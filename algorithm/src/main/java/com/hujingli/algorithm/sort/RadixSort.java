package com.hujingli.algorithm.sort;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {1000, 100, 101, 202, 303};
        radixSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[l..r]����  ,  digit
    // l..r    3 56 17 100    3
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // �ж��ٸ���׼�����ٸ������ռ�
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) { // �ж���λ�ͽ�������
            // 10���ռ�
            // count[0] ��ǰλ(dλ)��0�������ж��ٸ�
            // count[1] ��ǰλ(dλ)��(0��1)�������ж��ٸ�
            // count[2] ��ǰλ(dλ)��(0��1��2)�������ж��ٸ�
            // count[i] ��ǰλ(dλ)��(0~i)�������ж��ٸ�
            int[] count = new int[radix]; // count[0..9]
            for (i = L; i <= R; i++) {
                // 103  1   3
                // 209  1   9
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }




    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }


}
