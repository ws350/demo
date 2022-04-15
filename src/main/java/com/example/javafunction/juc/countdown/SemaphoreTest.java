package com.example.javafunction.juc.countdown;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author xiaoma
 * @desc ...抢车位  3个车位 6个车子
 * @date 2021-10-01 00:36:11
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //三个车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                //6个车子抢车位
                try {
                    semaphore.acquire();  //抢到车位
                    System.out.println(Thread.currentThread().getName() +"抢到车位");
                    TimeUnit.SECONDS.sleep(2);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                    semaphore.release();
                }
            },String.valueOf(i)).start();

        }
    }
}
