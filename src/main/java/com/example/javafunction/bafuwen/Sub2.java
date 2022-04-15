package com.example.javafunction.bafuwen;

/**
 * @Author vansn
 * @Date 2022/3/18 下午10:46
 * @Version 1.0
 * @Description
 */
public class Sub2 extends Parent2{

    static String substaticName = "staticSubName";

    static{
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类普通代码");
    }

    Sub2(){
        System.out.println("子类构造方法");

    }

    @Override
    void setName() {
        //super.setName();
        System.out.println("子类A方法");
    }
}
