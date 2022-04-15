package com.example.designmodel.bridge;




/**
 * @author xiaoma
 * @desc 形状类
 * @date 2021-10-28 16:45:52
 */
public abstract class Shape {
    Color color;
    public void setColor(Color color){
        this.color = color;
    }
    public abstract void draw();
}
