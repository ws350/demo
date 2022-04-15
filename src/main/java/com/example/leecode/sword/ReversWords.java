package com.example.leecode.sword;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author vansn
 * @Date 2022/3/9 上午9:39
 * @Version 1.0
 * @Description 反转单词顺序
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class ReversWords {
    public static void main(String[] args){
      String s = "the sky is blue";
        System.out.println(reversWords(s));
    }

    public static String reversWords(String s){
        Stack<StringBuilder> stack = new Stack<StringBuilder>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != ' '){
                sb.append(s.charAt(i));
            }else{
                sb.append(s.charAt(i));
                stack.push(sb);
                sb = new    StringBuilder();
            }
        }
        StringBuilder sb1 = new StringBuilder();
        while(stack.size() >0){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static String reversWords2(String s){
        //List<String> list = new ArrayList<String>();
        //list = Arrays.asList(s.split(" "));
        String[] str = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = str.length-1;i>=0;i--){
            sb.append(str[i] + " ");
        }
        return sb.toString();
    }
}
