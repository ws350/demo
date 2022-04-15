package com.example.leecode;

import java.util.List;

/**
 * @author xiaoma
 * @desc ...* Definition for singly-linked list.

 * @date 2021-10-11 16:04:42
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，
 * 并且每个节点只能存储一位数字。
 *请你将两个数相加，并以相同形式返回一个表示和的链表。
 *你可以假设除了数字 0 之外，这两个数都不会以 0开头
 *
 */
public class addTwoSum {



    public ListNode addTwoSum(ListNode l1,ListNode l2){
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while(l1 !=null || l2 != null){
            int n1=l1!=null?l1.val:0;
            int n2=l2!=null?l2.val:0;
            int sum = n1+n2+carry;
            //先把头挂住，用tail来做后面的加法
            if(head == null){

                head = tail = new ListNode(sum%10);

            }else{
                tail.next = new ListNode(sum %10);
                tail = tail.next;
            }
            carry = sum/10;
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l1=l2.next;
            }
        }
        if(carry >0){
            tail.next=new ListNode(carry);
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