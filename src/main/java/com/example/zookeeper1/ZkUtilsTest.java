package com.example.zookeeper1;

/**
 * @Description
 * @Author: vansn
 * @Date: 2021/12/13 下午4:40
 */
public class ZkUtilsTest {
    public static void main(String[] args) throws Exception{
        ZkUtils zkUtils = new ZkUtils();
        zkUtils.connectZookeeper("101.35.246.213:2181");
        zkUtils.creatNodes("/zkUtils","1");
    }
}
