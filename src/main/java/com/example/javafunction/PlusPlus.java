package com.example.javafunction;

/**
 * @Author vansn
 * @Date 2022/2/17 上午11:52
 * @Version 1.0
 * @Description
 */
public class PlusPlus {
    public static void main(String[] args){
        int x = 1;
        plusplus(++x);
        System.out.println(x);
        int j = 1;
        plusplus(j++);
        System.out.println(j);

    }

    public static void plusplus(int i){
        System.out.println(i);
    }
}
