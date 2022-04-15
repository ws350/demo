package com.example.leecode.sword;

/**
 * @Author vansn
 * @Date 2022/2/17 下午3:12
 * @Version 1.0
 * @Description
 */
public class ReverseLeftWords58 {

    public static String reverseLeftWords(String s,int n){
        char[]  array = s.toCharArray();
        //char[]  newArr = new char[s.length()];
        String a = s.substring(0,n);
        String b = s.substring(n,s.length());
        return  a+b;


    }
}
