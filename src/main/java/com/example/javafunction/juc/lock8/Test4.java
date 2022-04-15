package com.example.javafunction.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoma
 * @desc ...静态的同步方法  和普通的方法
 *         锁的是class    锁的是调用者
 *
 * @date 2021-09-23 10:29:22
 */
public class Test4{

    public static void main(String[] args) {
        Phone4 phone = new Phone4();
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
            phone1.hello();
        },"C").start();

    }
}

class Phone4{

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

    public synchronized void  hello(){
        System.out.println("hello ");
    }
}
