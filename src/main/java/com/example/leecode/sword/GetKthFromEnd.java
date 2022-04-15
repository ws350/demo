package com.example.leecode.sword;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author vansn
 * @Date 2022/3/3 上午10:49
 * @Version 1.0
 * @Description 倒数第n个节点
 */
public class GetKthFromEnd {


    public ListNode getKthFromEnd(ListNode node,int k){
        if(node == null || k <1) return null;

        ListNode cur = node;
        List<ListNode> list = new ArrayList<>();
        list.add(cur);
        while(cur.next != null){
            list.add(cur.next);
        }
        if(k>list.size()) return null;
        return list.get(list.size() - k);
    }
}
