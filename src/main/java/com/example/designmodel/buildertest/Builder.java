package com.example.designmodel.buildertest;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-06-03 16:18:36
 */
public abstract class Builder {
    abstract void buildBoard(String board);
    abstract void buildDisplay(String display);
    abstract void buildOs();

    abstract Computer build();
}
