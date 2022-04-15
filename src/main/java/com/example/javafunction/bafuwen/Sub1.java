package com.example.javafunction.bafuwen;

/**
 * @Author vansn
 * @Date 2022/3/10 上午11:49
 * @Version 1.0
 * @Description
 */
public class Sub1 extends Parent1{
    static int x = 3;


    Sub1(){
        this.echo();
        this.x = 4;
    }

    public void echo(){
        Sub1.x = this.x;

    }
    public int getx(){
        return this.x;
    }


}
