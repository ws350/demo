package com.example.designmodel.bridge;

/**
 * @author xiaoma
 * @desc 灰色的
 * @date 2021-10-28 16:53:02
 */
public class Gray implements Color{

    @Override
    public void bepaint(String shape) {
        System.out.println("灰色的"+shape);

    }


}
