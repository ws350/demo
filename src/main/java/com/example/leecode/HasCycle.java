package com.example.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author vansn
 * @Date 2022/2/8 下午8:12
 * @Version 1.0
 * @Description  存在环形链表
 */
public class HasCycle {

    public static boolean hasCycle(ListNode node){
        Set<ListNode> set= new HashSet<ListNode>();
        while(node != null){
            if(!set.add(node)){
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
