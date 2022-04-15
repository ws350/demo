package com.example.baguwen.cglib;

/**
 * @author xiaoma
 * @desc ...切面类
 * @date 2021-09-20 22:36:54
 */
public class Advices {
    public void log(){
        System.out.println("打印日志");
    }

    public void transaction(){
        System.out.println("事务操作");
    }

}
