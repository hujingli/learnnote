package com.hujingli.algorithm.leetcode;

public class LeetCode19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode now = head;
        ListNode last = head;
        for (int i=0;i<=n;i++){
            if(now.next !=null){
                now = now.next;
            }
        }
        while(now!=null && now.next!=null){
            now = now.next;
            last = last.next;
        }
        last.next = last.next.next;
        return last;
    }
}
