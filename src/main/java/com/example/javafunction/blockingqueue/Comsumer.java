package com.example.javafunction.blockingqueue;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author vansn
 * @Date 2022/4/12 下午4:51
 * @Version 1.0
 * @Description
 */
public class Comsumer implements Runnable{
    private BlockingQueue<String> queue;
    private static final int DEFAULT_RANGE_FOR_SLEEP = 1000;


    public Comsumer(BlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("启动消费者线程!");
        Random r = new Random();
        boolean isRunning = true;
        try{
            while (isRunning){
                System.out.println("从队列取走数据");
                String data = queue.poll(2, TimeUnit.SECONDS);


                if(null != data){
                    System.out.println("拿到数据："+ data);
                    System.out.println("正在消费数据："+ data);
                    Thread.sleep(r.nextInt(DEFAULT_RANGE_FOR_SLEEP));
                }else {
                    //超过2秒还数据，认为所有生产线程都退出了，退出消费线程
                    isRunning = false;
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("退出消费线程");
        }
    }
}
