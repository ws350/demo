package com.example.leecode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author vansn
 * @Date 2022/2/8 下午8:27
 * @Version 1.0
 * @Description  相交链表
 */
public class IntersectionNode {

    public static ListNode IntersectionNode(ListNode A,ListNode B){
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode tempA = A;
        while(tempA != null){
            set.add(tempA);
            tempA = tempA.next;
        }
        ListNode tempB = B;
        while (tempB != null){
            if(!set.add(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        return  null;
    }
}
