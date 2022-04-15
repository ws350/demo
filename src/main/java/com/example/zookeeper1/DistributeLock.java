package com.example.zookeeper1;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import sun.java2d.SurfaceDataProxy;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-08-20 11:38:33
 */
public class DistributeLock {

    private final String connectString = "101.35.246.213:2181";
    private final int sessionTimeOut = 2000;
    private final ZooKeeper zk;
    private CountDownLatch connectLatch = new CountDownLatch(1); //等待连接后才可以继续
    private String watiPath ;
    private CountDownLatch waitLatch = new CountDownLatch(1);
    private String curMode;

    public DistributeLock() throws IOException, InterruptedException, KeeperException {
        //获取连接
         zk = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                //连接上，释放 connectLatch  waitLatch
                if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
                    connectLatch.countDown();
                }
                //是删除事件 且是 前一个节点的删除
                if(watchedEvent.getType() == Event.EventType.NodeDeleted && watchedEvent.getPath().equals(watiPath)){
                    waitLatch.countDown();
                }

            }
        });

        //等待连接后才往下走
         connectLatch.await();



        //判断根节点/locks/是否存在
        Stat exists = zk.exists("/locks", false);
        if(exists == null){
            //创建根节点
            zk.create("/locks","locks".getBytes(), ZooDefs.Ids.CREATOR_ALL_ACL,CreateMode.PERSISTENT);

        }

    }


    /**
     * 加锁
     */
    public void zkLock() throws KeeperException, InterruptedException {
        //创建临时带序号节点
        curMode = zk.create("/locks/" + "seq-", null, ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.EPHEMERAL_SEQUENTIAL);

        //判断是否序号最小的，如果不是，监听前一个节点
        List<String> children = zk.getChildren("/locks", false);
        if(children.size() == 1){
            return;
        }else{
            Collections.sort(children);  //排序
        }

        //获取节点名称
        String thisNode= curMode.substring("/locks/".length());

        int thisIndex = children.indexOf(thisNode);
        if(thisIndex == -1 ){
            System.out.println("异常");
        }else if(thisIndex == 0){
            return;  //获取锁
        }{
            //监听  前一个节点
            watiPath = "/locks/" + children.get(thisIndex-1);
            zk.getData(watiPath,true,null);

            waitLatch.await();
        }

        //
    }

    /**
     *
     */
    public void zkUnlock() throws KeeperException, InterruptedException {
        //删除节点
        zk.delete(curMode,-1);
    }

}
