package com.example.leecode.sword;

import java.util.Stack;

/**
 * @Author vansn
 * @Date 2022/2/16 上午9:14
 * @Version 1.0
 * @Description 链表反向输出
 */
public class ReversePrint {


    public static int[] reversePrint(ListNode node){

        if(node == null ){
            return null;
        }else if(node.next == null){
            return new int[]{node.val};
        }
        Stack<Integer> stack = new Stack<>();
        //int[] res = new int[];
        ListNode cur = node;
        while (cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        int i=0;
        while(!stack.empty()){
            res[i++] = stack.pop();
        }
        return res;
    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }