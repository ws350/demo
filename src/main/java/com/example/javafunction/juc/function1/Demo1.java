package com.example.javafunction.juc.function1;

import java.util.function.Function;

/**
 * @author xiaoma
 * @desc ...function函数型接口,有一个输入，有一个输出
 * @date 2021-10-08 17:02:10
 */
public class Demo1 {
    public static void main(String[] args) {
//        Function function = new Function<String,Integer>() {
//
//            @Override
//            public Integer apply(String str) {
//                return Integer.valueOf(str);
//            }
//        };

        Function<String,Integer> function = (str)->{return  Integer.valueOf(str);};
        System.out.println(function.apply("111"));
    }
}
