package com.example.javafunction.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author vansn
 * @Date 2022/4/5 下午10:18
 * @Version 1.0
 * @Description
 */
public class TimerUse {
    public static void main(String[] args){
       //timer1();
        timer4();
    }


    /**
     * 设定指定任务task在指定时间time执行
     * schedule(TimerTask task, Date time)
     */
    public static void timer1(){
        Timer timer = new Timer();
        Date date = new Date();
        System.out.println(date.getTime());
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println(date.getTime());
                //System.out.println("");
            }
        },2000);
    }

    /**
     * 设定指定任务task在指定延迟delay后进行固定延迟peroid的执行
     *  延迟5秒后 每秒执行任务
     */
    public static void timer2(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("----指定执行任务----");
            }
        },5000,1000);
    }

    /**
     * 设定指定任务task在指定延迟delay后进行固定频率peroid的执行。
     *
     */
    public static void timer3(){
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("---指定执行任务");
            }
        },1000,2000);
    }


    /**
     * 安排指定的任务task在指定的时间firstTime开始进行重复的固定速率period执行．
     */
    public static void timer4(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY,12);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        // 得出执行任务的时间,此处为今天的12：00：00
        Date time = calendar.getTime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行固定任务");
            }
        },time,1000*60*60*24);// 这里设定将延时每天固定执行
    }

    public static void TaskByThread(){
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("执行任务");
                    try{
                        Thread.sleep(timeInterval);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();

    }

    /**
     * 最理想的定时任务实现方式。
     * 比于Timer的单线程，它是通过线程池的方式来执行任务的
     * 可以很灵活的去设定第一次执行任务delay时间
     * 提供了良好的约定，以便设定执行的时间间隔
     */
    public static void ScheduledTask(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Schedule task ");
            }
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable,10,1, TimeUnit.SECONDS);
    }



}
