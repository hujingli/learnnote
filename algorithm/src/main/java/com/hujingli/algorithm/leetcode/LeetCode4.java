package com.hujingli.algorithm.leetcode;

public class LeetCode4 {

    public static void main(String[] args) {
        LeetCode4 code4 = new LeetCode4();
        System.out.println(code4.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int a = nums1.length;
        int b = nums2.length;

        // 中位数第几个
        int k1 = (a + b + 1) / 2;
        int k2 = (a + b + 2) / 2;

        return (get(nums1, 0, a - 1, nums2, 0, b - 1, k1) + get(nums1, 0, a - 1, nums2, 0, b - 1, k2)) * 0.5;


    }

    public int get(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        int len1 = right1 - left1 + 1;
        int len2 = right2 - left2 + 1;
        if (len1 > len2) {
            return get(nums2, left2, right2, nums1, left1, right1, k);
        }

        // 如果其中一个数组空了，那么直接取第二个数组的剩余的第k小个数
        if (len1 == 0) {
            return nums2[left2 + k - 1];
        }

        // 如果k==1 那么去两个数组中小的那个开头
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }

        // 防止越界
        int i = left1 + Math.min(len1, k / 2) - 1;
        int j = left2 + Math.min(len2, k / 2) - 1;

        // 哪块小移除哪一块  然后将k 减去移除的个数
        if (nums1[i] < nums2[j]) {
            return get(nums1, i + 1, right1, nums2, left2, right2, k - (i - left1 + 1));
        } else {
            return get(nums2, j + 1, right2, nums1, left1, right1, k - (j - left2 + 1));
        }

    }

}
