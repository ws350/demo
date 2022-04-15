package com.example.javafunction.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoma
 * @desc ...增加两个静态的同步方法
 *   锁的是phone.class 是全局唯一的
 * @date 2021-09-23 10:29:22
 */
public class Test3{

    public static void main(String[] args) {
        Phone3 phone = new Phone3();
        Phone3 phone1 = new Phone3();
        new Thread(()->{
            phone.sendMsg();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        new Thread(()->{
            phone1.call();
        },"C").start();

    }
}

class Phone3{

    public static synchronized void sendMsg(){

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("send a msg");
    }

    public static synchronized void call(){
        System.out.println("call  ");
    }

    public void hello(){
        System.out.println("hello ");
    }
}
