package com.example.javafunction.juc.function1;

import java.util.function.Consumer;

/**
 * @author xiaoma
 * @desc 消费型接口  只有输入，没有返回
 * @date 2021-10-08 17:48:43
 */
public class ConsumerInterface {

    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };
        Consumer<String> consumer =(str)->{ System.out.println(str); };
                consumer.accept("str1");
    }
}
