package com.hujingli.algorithm.offer;

/**
 * 合并排序两个链表
 */
public class JZ16 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(6);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        JZ16 jz16 = new JZ16();
        ListNode merge = jz16.Merge(listNode1, listNode4);
        System.out.println(merge);
    }

    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode  newNode;

        if (list1.val <= list2.val) {
            newNode = new ListNode(list1.val);
            list1 = list1.next;
        } else {
            newNode = new ListNode(list2.val);
            list2 = list2.next;
        }
        ListNode origin = newNode;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            newNode = newNode.next;
        }
        if (list1 == null) {
            newNode.next = list2;
        }
        if (list2 == null) {
            newNode.next = list1;
        }
        return origin;
    }

}
