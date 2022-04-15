package com.example.leecode;

import com.sun.xml.internal.xsom.impl.ForeignAttributesImpl;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * @Author vansn
 * @Date 2022/1/25 上午11:15
 * @Version 1.0
 * @Description 有效的括号
 */
public class ValidBrackets {

    public static void main(String[] args){
      String s = "{}[]()({})";
        System.out.println(isValid(s));
        System.out.println(isValid3("(])"));
    }

    public static boolean isValid(String str){
        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');

        Deque<Character> queue = new LinkedList<>();
        for(int i = 0 ;i<str.length();i++){
            char s = str.charAt(i);
            if(map.containsKey(s)){
                queue.add(s);
            }else{
                //匹配上
                System.out.println("match: " +queue.peek() + "   "+s);
                if((queue.peek()+"") == (s+"")){
                    queue.remove();
                }else{
                    queue.push(s);
                }
            }
            System.out.println("queue :  "+queue.toString());

        }
       return queue.isEmpty();
    }



    public static boolean isValid3(String s) {
        if(s.length() ==0) return true;

        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)) ){
                //是右边的
                if(stack.empty()){
                    return false;
                }else if(stack.peek().equals(map.get(s.charAt(i)))){
                    stack.pop();
                }
            } else
            stack.push(s.charAt(i));
        }
        return stack.empty();
    }
}
