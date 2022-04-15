package com.example.baguwen.cglib;

/**
 * @author xiaoma
 * @desc AspectJ Test
 * @date 2021-09-20 23:13:54
 */
public class AspectJTest {

    public static void main(String[] args) {
        AspectJTest ajT = new AspectJTest();
        ajT.service();

    }


    public void service(){
        System.out.println("aspectj service");
    }
}
