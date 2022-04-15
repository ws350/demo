package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/2/12 下午10:42
 * @Version 1.0
 * @Description  汉明距离
 */
public class HanmingDistance {

    public static void main(String[] args){
        //byteCOunt();

    }


    //内置的bit运算
    public static int hanmingDistance(int x,int y){
        return Integer.bitCount(x ^ y);
    }

    //位移实现
    public static int hanmingDistance2(int x,int y){
        int s = x^ y,ret = 0;
        while(s!=0){
            ret = ret + s & 1;  //s &1 判断最后1位是不是1
            s = s >>1;
        }
        return s;
    }

    public static void byteCOunt(){
        int x = 5;  // 101
        int y = 6;  // 110
        int s = x ^ y;  //异或
        int ss = x & y ;  //与
        int sss = x | y;  //或
        System.out.println(s);
        System.out.println(ss);
        System.out.println(sss);

        int a = x >> 1;
        System.out.println("5:101 右移1位 ：" + a);


    }

}
