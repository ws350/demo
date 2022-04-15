package com.example.designmodel.buildertest;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-06-03 16:06:41
 */
public abstract class Computer {
    //电脑由 主板 显示器 操作系统组成
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    protected Computer(){}

    public void setBoard(String board){
        mBoard = board;
    }

    public void setDisplay(String display){
        mDisplay = display;
    }
    public abstract  void setOs();


    @Override
    public String toString() {
        return "Computer{" +
                "mBoard="+mBoard+"  ,"+
                "mDisplay= "+mDisplay+"  ,"+
                "mOS = "+mOs+ "}";
    }
}
