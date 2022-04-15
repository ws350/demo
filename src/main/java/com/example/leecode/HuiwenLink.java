package com.example.leecode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author vansn
 * @Date 2022/2/11 下午3:27
 * @Version 1.0
 * @Description 回文链表
 */
public class HuiwenLink {

    public static void main(String[] args){
      ListNode node4 = new ListNode(1);
      ListNode node3 = new ListNode(2);
      node3.next = node4;
      ListNode node2 = new ListNode(2);
      node2.next = node3;
      ListNode node1 = new ListNode(1);
      node1.next = node2;
        System.out.println(huiwenLink(node1));

    }


    public static boolean huiwenLink(ListNode node){
        if(node == null ){
            return false;
        }else if( node.next == null){
            return true;
        }

        Deque queue = new LinkedList();
        queue.add(node.val);
        while(node.next != null){

            if((int)queue.peekFirst()== node.next.val){

                //peek()方法 返回顶部 但不删除
                queue.pollFirst(); //返回顶部并删除
            }else{
                queue.addFirst(node.next.val);
            }
            node = node.next;

        }
        return queue.isEmpty();



    }
}
