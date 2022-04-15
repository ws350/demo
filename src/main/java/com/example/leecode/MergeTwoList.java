package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/1/25 下午8:58
 * @Version 1.0
 * @Description 合并两个链表
 */
public class MergeTwoList {


    public static void main(String[] args){
       ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode ll1 = new ListNode(1);
        ListNode ll2 = new ListNode(2);
        ListNode ll3 = new ListNode(2);
        ListNode ll4 = new ListNode(5);
        ListNode ll5 = new ListNode(8);
        ll1.next = ll2;
        ll2.next = ll3;
        ll3.next = ll4;
        ll4.next = ll5;
        merge(l1,ll1);

    }


    public static ListNode merge(ListNode l1,ListNode l2) {
        ListNode head, temp, cur = null;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }


    }

}
