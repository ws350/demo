package com.example.zookeeper1;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-08-20 15:22:02
 */
public class CuratorLock {

    public static void main(String[] args) {
        //创建分布锁1
        InterProcessMutex lock1 = new InterProcessMutex(getCuratorFramework(),"/locks");

        InterProcessMutex lock2 = new InterProcessMutex(getCuratorFramework(),"/locks");


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.acquire();

                    lock1.acquire(); //重入

                    Thread.sleep(5000);

                    lock1.release();

                    lock1.release(); //再次释放

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.acquire();

                    lock2.acquire(); //重入

                    Thread.sleep(5000);

                    lock2.release();

                    lock2.release(); //再次释放

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static CuratorFramework getCuratorFramework(){
        ExponentialBackoffRetry policy = new ExponentialBackoffRetry(3000,3);

        CuratorFramework client = CuratorFrameworkFactory.builder().
                connectString("101.35.245.213:2181").
                connectionTimeoutMs(2000).
                sessionTimeoutMs(2000).
                retryPolicy(policy).build();

        //启动客户端
        client.start();
        return client;

    }
}
