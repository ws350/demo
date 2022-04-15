package com.example.javafunction.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoma
 * @desc condition 的使用
 *   A执行完调用B-->C
 * @date 2021-09-22 16:10:16
 */
public class C {
    public static void main(String[] args) {
        Data3 data3 = new Data3();
        new Thread(()->{
            for (int i=0;i<10;i++) {
                data3.printA();
            }
        },"A").start();
        new Thread(()->{for (int i=0;i<10;i++) {
            data3.printB();
        }},"B").start();
        new Thread(()->{for (int i=0;i<10;i++) {
            data3.printC();
        }},"C").start();

    }
}

class Data3{
    private Lock lock= new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num = 1;
    public void printA(){
        lock.lock();
        try {
            //业务代码
            //A只能有1
            while(num !=1){
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"A:");
          //唤醒指定的2
            num = 2;
            condition2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }
    public void printB(){
        lock.lock();
        try {
            while(num !=2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"B:");
            num =3;
            //唤醒3
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void printC(){
        lock.lock();
        try {
            while(num !=3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"C:");
            num=1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }

}