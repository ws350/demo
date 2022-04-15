package com.example.javafunction.juc.unsafe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xiaoma
 * @desc ...
 *
 * java.util.ConcurrentModificationException 并发下出现的异常
 * 并发下list是不安全的-->vector(线程安全 vector比list先出来)
 * collections.cync
 * copyonwritearrrylist 写入时复制：
 * 多个线程调用的时候，读取的时候是固定的，写入的时候给他复制一份副本，再放回去，避免造成数据问题
 * @date 2021-09-24 10:24:56
 */
public class ListTest {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("1","2","3");
//        list.forEach(System.out::println);
       // ArrayList<String>  list = new ArrayList<>();

        //List<String>  list = new Vector<>();   1
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list =new CopyOnWriteArrayList<>();
        for(int i= 0;i<10;i++){
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();
        }

    }
}
