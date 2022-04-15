package com.example.designmodel.bridge;

/**
 * @author xiaoma
 * @desc ...
 * @date 2021-10-28 16:58:35
 */
public class Client {
    public static void main(String[] args) {
        Color white = new White();
        Shape square = new Square();
        square.setColor(white);
        square.draw();
        //相当于画了个白色的正方形

        Color red = new Gray();
        Shape rectangle = new Rectangle();
        rectangle.setColor(red);
        rectangle.draw();
    }
}
