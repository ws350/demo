package com.example.javafunction;

/**
 * @Description
 * @Author: vansn
 * @Date: 2021/12/28 上午11:44
 */
public class DeadLock {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            synchronized (lock1){
                try{
                    System.out.println("thread1 begin");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            synchronized (lock2){
                System.out.println("sync  lock2");
            }
        }).start();

        new Thread(()->{
            synchronized (lock2){
                try{
                    System.out.println("thread2 begin");
                    Thread.sleep(5000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            synchronized (lock1){
                System.out.println("sync  lock1");
            }
        }).start();
    }
}
