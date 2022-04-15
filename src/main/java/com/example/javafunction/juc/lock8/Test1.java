package com.example.javafunction.juc.lock8;

import java.util.concurrent.TimeUnit;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-09-23 10:29:22
 */
public class Test1 {

    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendMsg();
        },"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone.call();
        },"B").start();

    }
}

class Phone{

    public synchronized void sendMsg(){

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("send a msg");
    }

    public synchronized void call(){
        System.out.println("call  ");
    }
}
