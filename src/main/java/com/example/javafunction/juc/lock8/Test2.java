package com.example.javafunction.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-09-23 10:29:22
 */
public class Test2{

    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(()->{
            phone.sendMsg();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        new Thread(()->{
            phone.hello();
        },"C").start();

    }
}

class Phone2{

    public synchronized void sendMsg(){

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("send a msg");
    }

    public synchronized void call(){
        System.out.println("call  ");
    }

    public void hello(){
        System.out.println("hello ");
    }
}
