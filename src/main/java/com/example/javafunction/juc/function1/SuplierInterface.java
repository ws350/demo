package com.example.javafunction.juc.function1;

import java.util.function.Supplier;

/**
 * @author xiaoma
 * @desc 供给型接口  只有返回值
 * @date 2021-10-08 17:48:43
 */
public class SuplierInterface {

    public static void main(String[] args) {
//        Supplier supplier = new Supplier(){
//
//            @Override
//            public Object get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };
        Supplier supplier = ()->{return 1024;};
        System.out.println(supplier.get());
    }
}
