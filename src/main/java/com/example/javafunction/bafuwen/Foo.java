package com.example.javafunction.bafuwen;

/**
 * @Author vansn
 * @Date 2022/3/10 上午8:19
 * @Version 1.0
 * @Description
 */
public class Foo {

    public static void main(String[] args){
        int i= 0;
        for(foo('A');foo('b') && i<2;foo('C')){
            i++;
            foo('d');
        }
    }

    public static boolean foo(char a){
        System.out.print(a);
        return true;

    }
}
