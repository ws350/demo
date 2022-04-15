package com.example.leecode.sword;

import java.util.LinkedList;

/**
 * @Author vansn
 * @Date 2022/2/15 上午9:02
 * @Version 1.0
 * @Description  用两个栈实现队列
 *
 *   12345  插入
 *   删除  12345
 */
public class Cqueue09 {

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public Cqueue09() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    //尾部插入
    public void appendTail(int value) {
        stack1.push(value);
    }

    //删除头部
    public int deleteHead() {
        if(stack1.isEmpty() && stack2.isEmpty()){
            return -1;
        }
        if(!stack2.isEmpty()){
           return stack2.pop();  //remove first node
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
