package com.example.designmodel.buildertest;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-06-03 16:37:27
 */
public class MacBookBuilder extends Builder{

    private Computer mComputer = new MacBook();

    @Override
    void buildBoard(String board) {
        mComputer.setBoard(board);
    }

    @Override
    void buildDisplay(String display) {
        mComputer.setDisplay(display);
    }

    @Override
    void buildOs() {
        mComputer.setOs();
    }

    @Override
    Computer build() {
        return mComputer;
    }
}
