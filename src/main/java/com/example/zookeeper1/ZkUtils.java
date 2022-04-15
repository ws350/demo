package com.example.zookeeper1;

import com.example.javafunction.juc.countdown.Countdownlaunch;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author: vansn
 * @Date: 2021/12/13 下午4:26
 */
public class ZkUtils implements Watcher {

    private ZooKeeper zooKeeper;
    private static final int SESSION_TIME_OUT = 2000;

    private CountDownLatch countDownLatch = new CountDownLatch(1); //等待连接后才可以继续


    public void process(WatchedEvent event){
        if(event.getState() == Watcher.Event.KeeperState.SyncConnected){
            System.out.println("watch received event");
            countDownLatch.countDown();
        }
    }



    //connect zk
    public void connectZookeeper(String host) throws Exception {
        zooKeeper = new ZooKeeper(host,SESSION_TIME_OUT,this);
            countDownLatch.await();
        System.out.println("connect zk success");
    }


    //add
    public String creatNodes(String path,String data) throws Exception{
        return this.zooKeeper.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);

    }


}
