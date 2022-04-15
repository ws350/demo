package com.example.javafunction.juc.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author xiaoma
 * @desc ...
 *
 * set也会抛出 并发修改异常
 *
 * @date 2021-09-24 12:43:33
 */
public class SetTest {
    public static void main(String[] args) {
        Set<Object> set0 = new HashSet<>();
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set = new CopyOnWriteArraySet<>();

        for(int i=0;i<60;i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(1)).start();
        }



    }
}
