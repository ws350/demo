package com.example.javafunction.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-05-18 12:24:06
 */
public class JucTest {


    public static void main(String[] args) throws InterruptedException {
        //获取CPU核数
        System.out.println(Runtime.getRuntime().availableProcessors());

        //线程的状态
        //new Thread.State;
        //睡眠10天
        TimeUnit.DAYS.sleep(10);

        //
        //Lock
    }
}
