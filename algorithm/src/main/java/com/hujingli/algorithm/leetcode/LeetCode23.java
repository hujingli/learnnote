package com.hujingli.algorithm.leetcode;

/**
 * @author exphuhong
 * @date 2021/4/12 0012
 */
public class LeetCode23 {

    public static void main(String[] args) {

    }
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length-1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) >> 1;
        return merge2List(merge(lists, 0, mid), merge(lists, mid + 1, end));
    }

    public ListNode merge2List(ListNode leftNode, ListNode rightNode) {
        if (leftNode == null) {
            return rightNode;
        }
        if (rightNode == null) {
            return leftNode;
        }

        ListNode newNode = new ListNode(0);
        ListNode tailNode = newNode;
        ListNode lcur = leftNode, rcur = rightNode;
        while (lcur != null && rcur != null) {
            if (lcur.val <= rcur.val) {
                tailNode.next = new ListNode(lcur.val);
                lcur = lcur.next;
            } else {
                tailNode.next = new ListNode(rcur.val);
                rcur = rcur.next;
            }
            tailNode = tailNode.next;
        }
        tailNode.next = lcur == null ? rcur : lcur;
        return newNode;
    }

}
