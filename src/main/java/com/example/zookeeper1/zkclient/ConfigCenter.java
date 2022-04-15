package com.example.zookeeper1.zkclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;
import org.mockito.internal.matchers.Null;

import java.util.concurrent.CountDownLatch;

/**
 * @Description
 * @Author: vansn
 * @Date: 2021/12/14 下午8:45
 */

@Slf4j
public class ConfigCenter {

    private final static String CONNECT_IP = "101.35.246.213:2181";
    private static ZooKeeper zooKeeper;
    private static final int SESSION_TIME_OUT = 2000;

    private static CountDownLatch countDownLatch = new CountDownLatch(1); //等待连接后才可以继续

    public static void main(String[] args) throws Exception{
        //此方法是另起一个守护线程，当业务线程结束，守护线程也会退出
        //所以需要用countdownLatch,在没建立好连接时一直等待，等待连接建立好之后，再继续业务逻辑
        zooKeeper = new ZooKeeper(CONNECT_IP, SESSION_TIME_OUT, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType() ==Event.EventType.None &&
                 watchedEvent.getState() ==Event.KeeperState.SyncConnected){
                    System.out.println("connect success");
                    countDownLatch.countDown();
                }
            }
        });
        countDownLatch.await();


        MyConfig myConfig = new MyConfig();
        myConfig.setKey("anykey");
        myConfig.setName("anyName");

        ObjectMapper objectMapper = new ObjectMapper();
        byte[] bytes = objectMapper.writeValueAsBytes(myConfig);

        String s = zooKeeper.create("/Myconfig", bytes, ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);


        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                if(watchedEvent.getType()== Event.EventType.NodeDataChanged
                && watchedEvent.getPath()!= null
                && watchedEvent.getPath().equals("/Myconfig")){
                    System.out.println("数据改变了"+watchedEvent.getPath());
                    byte[] data = new byte[0];
                    try {
                        data = zooKeeper.getData("/Myconfig", this, null);
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //拿到数据进行反序列化
                    try {
                        MyConfig myConfig1 = objectMapper.readValue(new String(data), MyConfig.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }

                    System.out.println("变化后的数据");

                }


            }
        };
        byte[] data = zooKeeper.getData("/Myconfig", watcher, null);

        MyConfig orgmyConfig1 = objectMapper.readValue(new String(data), MyConfig.class);
        System.out.println("原始数据"+orgmyConfig1);

    }


}
