package com.example.designmodel.buildertest;

/**
 * @author xiaoma
 * @desc  具体产品
 * @date 2021-06-03 16:14:35
 */
public class MacBook extends Computer{

    protected MacBook(){}

    @Override
    public void setOs() {
        mOs ="Mac OS X 12";
    }
}
