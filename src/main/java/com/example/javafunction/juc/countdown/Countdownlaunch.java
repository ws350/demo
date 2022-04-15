package com.example.javafunction.juc.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * @author xiaoma
 * @desc ...减法计数
 * @date 2021-09-30 23:55:15
 */
public class Countdownlaunch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i=0;i<=6;i++) {
           new Thread(()->{
               System.out.println(Thread.currentThread().getName()+"号线程执行中。。");
               countDownLatch.countDown();


           },String.valueOf(i)).start();


        }

        System.out.println("线程执行结束");
        countDownLatch.await();
        System.out.println("线程通过");
    }



}
