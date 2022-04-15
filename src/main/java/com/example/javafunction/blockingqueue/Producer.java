package com.example.javafunction.blockingqueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author vansn
 * @Date 2022/4/12 下午4:37
 * @Version 1.0
 * @Description
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true; //运行标志
    private BlockingQueue queue;               //阻塞队列
    private static AtomicInteger count = new AtomicInteger();//自动更新的值
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;

    //构造函数
    public Producer(BlockingQueue queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        String data = null;
        Random r = new Random();

        System.out.println("生产者线程启动");

        try{
            while (isRunning){
                System.out.println("正在生产数据");
                Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));

                data = "data" + count.incrementAndGet(); //原子的方式加一
                System.out.println("将数据  " + data + "  放入队列");
                if(!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.out.println("放入队列失败：" + data);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }finally {
            System.out.println("退出生产者线程！");
        }
    }

    public void stop(){
        isRunning = false;
    }
}
