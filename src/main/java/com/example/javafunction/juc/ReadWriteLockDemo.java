package com.example.javafunction.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-10-01 23:44:00
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        Mycahce mycahce = new Mycahce();
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(()->{
                mycahce.put(temp+"",temp+"");

            },String.valueOf(i)).start();

        }
        for (int i = 5; i < 10; i++) {
            final int temp = i;
            new Thread(()->{
                mycahce.get(temp+"");

            },String.valueOf(i)).start();

        }
    }

}


class Mycahce{
   private volatile Map<String,Object> map =new HashMap<>();
   private ReadWriteLock lock = new ReentrantReadWriteLock();

   public void put(String key,Object value){
       lock.writeLock().lock();
       try {
           System.out.println(Thread.currentThread().getName()+"写入");
           map.put(key,value);
           System.out.println(Thread.currentThread().getName()+"写入完毕");
       } finally {
           lock.writeLock().unlock();
       }
   }



   public void get(String key){
       lock.readLock().lock();
       try {
           System.out.println(Thread.currentThread().getName()+"读取");
           map.get(key);
           System.out.println(Thread.currentThread().getName()+"读取完毕");
       } finally {
           lock.readLock().unlock();
       }
   }

}
