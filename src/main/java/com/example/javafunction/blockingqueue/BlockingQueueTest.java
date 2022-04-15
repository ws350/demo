package com.example.javafunction.blockingqueue;

import java.util.ConcurrentModificationException;
import java.util.concurrent.*;

/**
 * @Author vansn
 * @Date 2022/4/12 下午4:34
 * @Version 1.0
 * @Description
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        //声明一个容量为10的缓存队列
        BlockingQueue<String> queue = new LinkedBlockingQueue<String>(10);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);

        Comsumer comsumer = new Comsumer(queue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(comsumer);

        Thread.sleep(10*1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        Thread.sleep(2000);


        service.shutdown();
    }
}
