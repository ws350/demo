package com.example.leecode;

/**
 * @Author vansn
 * @Date 2022/1/26 下午4:03
 * @Version 1.0
 * @Description 爬楼梯
 */
public class ClimbeStairs {
    public static void main(String[] args){
        System.out.println(climbeStairs(100));
    }


    public  static int climbeStairs(int n){
        int q= 0,p= 0,r=1;
        for(int i=0;i<n;i++){
            p = q;
            q = r;
            r = p + q;
            System.out.println(r);
        }
        return r;

    }
}
