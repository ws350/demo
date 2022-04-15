package com.example.designmodel.buildertest;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-06-03 16:44:18
 */
public class Test {
    public static void main(String[] args) {
        Builder builder = new MacBookBuilder();
        Director pcDirector = new Director(builder);

        pcDirector.construct("英特尔主板","renita显示器");

        Computer computer = builder.build();

        System.out.println(computer.toString());
    }
}
