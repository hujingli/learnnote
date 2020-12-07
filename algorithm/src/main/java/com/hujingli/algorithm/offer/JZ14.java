package com.hujingli.algorithm.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中倒数第几个节点
 */
public class JZ14 {


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        JZ14 jz14 = new JZ14();
//        ListNode listNode = jz14.FindKthToTail(listNode1, 2);
//        System.out.println(listNode);

        ListNode listNode6 = jz14.FindKthToTail1(listNode1, 2);
        System.out.println(listNode6.val);
    }

    // {1,2,3,4,5}
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        List<ListNode> result = new ArrayList<>();
        result.add(head);
        while (head.next != null) {
            result.add(head.next);
            head = head.next;
        }
        if (k <= 0 || k > result.size()) {
            return null;
        }
        return result.get(result.size() - k);

    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode p, q;
        for (p = q = head; p != null; p = p.next, k--) {
            if (k <= 0) {
                q = q.next;
            }
        }
        return k <= 0 ? q : null;
    }


}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}