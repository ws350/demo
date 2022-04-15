package com.example.javafunction.bafuwen;

import java.sql.SQLOutput;

/**
 * @Author vansn
 * @Date 2022/3/18 下午10:46
 * @Version 1.0
 * @Description
 */
public class Parent2 {
    static{
        System.out.println("父类静态代码块");
    }

    static void staticMethod(){
        System.out.println("父类静态代码方法");
    }

    void setName(){
        System.out.println("父类A方法");

    }

    {
        System.out.println("父类普通代码块");
    }

    public Parent2(){
        System.out.println("父类构造方法");
    }
}
