package com.hujingli.algorithm.leetcode;

public class LeetCode2 {


    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null) {
            int vl1 = l1 != null ? l1.val : 0;
            int vl2 = l2 != null ? l2.val : 0;
            int sum = vl1 + vl2 + carry;
            int newVal = sum % 10;
            if (head == null) {
                head = tail = new ListNode(newVal);
            } else {
                tail.next = new ListNode(newVal);
                tail = tail.next;
            }
            // 进位数据
            carry = sum / 10;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }

}

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

