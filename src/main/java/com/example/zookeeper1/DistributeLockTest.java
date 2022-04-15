package com.example.zookeeper1;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-08-20 15:03:30
 */
public class DistributeLockTest {

    public static void main(String[] args) throws InterruptedException, IOException, KeeperException {


        final DistributeLock lock1 = new DistributeLock();
        final DistributeLock lock2 = new DistributeLock();



        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock1.zkLock();

                    Thread.sleep(5000);

                    lock1.zkUnlock();
                }catch (InterruptedException | KeeperException e){
                    e.printStackTrace();
                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    lock2.zkLock();

                    Thread.sleep(5000);

                    lock2.zkUnlock();
                }catch (InterruptedException | KeeperException e){
                    e.printStackTrace();
                }

            }
        }).start();

    }


}
