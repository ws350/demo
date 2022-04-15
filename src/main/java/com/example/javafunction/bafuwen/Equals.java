package com.example.javafunction.bafuwen;

/**
 * @Author vansn
 * @Date 2022/3/16 上午11:40
 * @Version 1.0
 * @Description
 */
public class Equals {
    public static void main(String[] args){
        String x = "abc";
        String y = "abc";
        System.out.println(x == y);

        String c = new String("abc");
        System.out.println(x == c);
        System.out.println(x.equals(c));
    }

}
