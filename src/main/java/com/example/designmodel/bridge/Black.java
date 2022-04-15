package com.example.designmodel.bridge;

/**
 * @author xiaoma
 * @desc 黑色
 * @date 2021-10-28 16:53:02
 */
public class Black implements Color{

    @Override
    public void bepaint(String shape) {
        System.out.println("黑色的"+shape);

    }


}
