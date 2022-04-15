package com.example.javafunction.ThreadPool1;

import org.elasticsearch.search.aggregations.metrics.InternalHDRPercentiles;
import org.springframework.core.task.support.ExecutorServiceAdapter;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.concurrent.*;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-10-08 14:51:57
 */
public class ThreadPoolOrg {

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());


        try {
            for(int i=0;i<=9;i++){
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() +"ok");

                });


            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }




}
