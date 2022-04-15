package com.example.designmodel.buildertest;

/**
 * @author xiaoma
 * @desc 负责构建具体的computer
 * @date 2021-06-03 16:41:30
 */
public class Director {
    Builder mBuilder = null;

    public Director(Builder builder){
        this.mBuilder = builder;
    }

    public  void construct(String board,String display){
        mBuilder.buildDisplay(display);
        mBuilder.buildBoard(board);
        mBuilder.buildOs();

    }
}
