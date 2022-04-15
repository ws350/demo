package com.example.leecode.sword;

import java.util.Stack;

/**
 * @Author vansn
 * @Date 2022/2/15 上午11:01
 * @Version 1.0
 * @Description
 */
public class MinStack30 {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MinStack30() {
       stack1 = new Stack<>();
       stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.add(x);
        //stack2 只插入比当前小的
        if(stack2.isEmpty()|| stack2.peek() >= x){
            stack2.push(x);
        }
    }

    public void pop() {
        if(stack1.pop().equals(stack1.peek()) ){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
