package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/2/16 上午9:43
 * @Version 1.0
 * @Description 反转链表
 */
public class ReverseList24 {

    public static ListNode reverseList(ListNode node){

        if(node == null){
            return null;
        }else if(node.next == null){
            return node;
        }
        ListNode cur = node,temp,pre = null;
        while(cur.next != null){
            temp = cur;
            temp.next = pre;
            pre = cur;
            cur = cur.next;
        }
        return cur;
    }
}
