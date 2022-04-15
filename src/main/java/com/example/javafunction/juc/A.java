package com.example.javafunction.juc;

/**
 * @author xiaoma
 * @desc A线程交替通行
 *    A num+1
 * @date 2021-09-22 15:17:39
 */
public class A {
    public static void main(String[] args) {
        Data data = new Data();
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
class Data{
    private int num = 0;

    //+1
    public synchronized void increment() throws InterruptedException {
        if(num !=0){
            //等待
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+num);
        //通知其他线程
        this.notifyAll();
    }
    //-1
    public synchronized void decrement() throws InterruptedException {
        if(num == 0){
            //等待
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+num);
        this.notifyAll();
        //通知其他线程
    }
}
