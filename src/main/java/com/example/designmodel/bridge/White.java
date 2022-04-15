package com.example.designmodel.bridge;

/**
 * @author xiaoma
 * @desc 白色
 * @date 2021-10-28 16:53:02
 */
public class White implements Color{

    @Override
    public void bepaint(String shape) {
        System.out.println("白色的"+shape);

    }


}
