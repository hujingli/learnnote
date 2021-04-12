package com.hujingli.algorithm.leetcode;

public class LeetCode24 {

    public static void main(String[] args) {
        LeetCode24 code24 = new LeetCode24();
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next  = head1;
        head1.next  = head2;
        head2.next = head3;
        System.out.println(code24.swapPairs(head));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

}


