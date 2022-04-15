package com.example.javafunction.juc.function1;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author xiaoma
 * @desc ...断定型  函数型接口, 有一个输入，有一个输出
 * @date 2021-10-08 17:02:10
 */
public class Demo2 {
    public static void main(String[] args) {
//        Predicate predicate = new Predicate<String>() {
//
//            @Override
//            public boolean test(String str) {
//                return str.isEmpty();
//            }
//        };
        Predicate<String> predicate =(str)->{return str.isEmpty();};
        System.out.println(predicate.test("sss"));

    }
}
