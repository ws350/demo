package com.example.javafunction.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoma
 * @desc A线程交替通行 --LOCK版本实现
 *    A num+1
 * @date 2021-09-22 15:17:39
 */
public class A1 {
    public static void main(String[] args) {
        Data1 data = new Data1();
        //T1用来+1 T2用来-1  达到线程通信的目的
        //利用的是wait和notify通信
        new Thread(()->{
            try {
                for (int i=0;i<10;i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1:").start();
        new Thread(()->{
            try {
                for (int i=0;i<10;i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2:").start();
    }
}
//等待 业务  通知
class Data1{
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    //+1
    public  void increment() throws InterruptedException {
        try {
            lock.lock();
            if(num !=0){
                //等待
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+num);
            //通知其他线程
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //-1
    public void decrement() throws InterruptedException {
        try {
            lock.lock();
            if(num == 0){
                //等待
               condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+num);

            //通知其他线程
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
