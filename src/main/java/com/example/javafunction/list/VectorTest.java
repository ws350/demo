package com.example.javafunction.list;

import java.util.Stack;
import java.util.Vector;

/**
 * @Author vansn
 * @Date 2022/2/15 下午3:02
 * @Version 1.0
 * @Description
 */
public class VectorTest {
    public static void main(String[] args){

        Vector<Integer> vector = new Vector<>();
        Stack<Integer> stack = new Stack<>();

        vector.add(1);
        vector.add(2);
        vector.remove(1);
        vector.remove(0);

        stack.push(1);
        stack.push(2);
        stack.add(3);
        System.out.println(stack.peek());
        stack.remove(3);



    }
}
