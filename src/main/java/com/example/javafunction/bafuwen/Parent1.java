package com.example.javafunction.bafuwen;

/**
 * @Author vansn
 * @Date 2022/3/10 上午8:46
 * @Version 1.0
 * @Description
 */
public class Parent1 {
    static int x = 0;

     Parent1(){
        this.echo();
        this.x = 1;
    }
    public int getx(){
        return this.x;

    }

    public void echo(){
        Parent1.x = this.x;
    }
}
